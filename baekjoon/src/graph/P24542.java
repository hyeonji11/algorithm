package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P24542 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int node = Integer.parseInt(inputs[0]);
        int edge = Integer.parseInt(inputs[1]);

        arr = new int[node+1];
        int valueArr[] = new int[node+1];
        BigInteger total = BigInteger.ONE;

        for(int i=1; i<=node; i++) {
            arr[i] = i;
        }

        for(int i=0; i<edge; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            union(a, b);
        }

        for(int i=1; i<=node; i++) {
            int value = find(i);
            valueArr[value]++;
        }
        for(int i=1; i<=node; i++) {
            if(valueArr[i] != 0)
                total = total.multiply(BigInteger.valueOf(valueArr[i]));
        }
        total = total.remainder(BigInteger.valueOf(1000000007));

        System.out.println(total);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    public static int find(int a) {
        if(arr[a] == a)
            return a;
        return arr[a] = find(arr[a]);
    }
}
