package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17352 {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        arr = new int[num+1];
        for(int i=1; i<=num; i++) {
            arr[i] = i;
        }

        for(int i=0; i<num-2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int first = arr[1];

        for(int i=2; i<=num; i++) {
            int value = find(arr[i]);
            if(value != first) {
                System.out.println(first+" "+value);
                break;
            }
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a < b)
            arr[b] = a;
        else
            arr[a] = b;
    }

    public static int find(int value) {
        if(arr[value] == value) return value;

        arr[value] = find(arr[value]);
        return arr[value];
    }
}
