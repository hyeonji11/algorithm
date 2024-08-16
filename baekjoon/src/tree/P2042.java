package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042 {
    static long[] tree;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int change = Integer.parseInt(st.nextToken());
        int sumNum = Integer.parseInt(st.nextToken());


        // 2^k >= num. 2^k *2
        k = (int) Math.ceil(Math.log(num)/Math.log(2)) + 1;
        int start = (int) Math.pow(2, k);
        tree = new long[start*2];

        for(int i=start; i<start+num; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        int index;
        for(int i=start+num; i>1; i--) {
            index = (int) Math.floor(i/2);
            tree[index] += tree[i];
        }

        int key, a;
        long b;
        for(int i=0; i<change+sumNum; i++) {
            st = new StringTokenizer(br.readLine());
            key = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Long.parseLong(st.nextToken());

            if(key == 1) {
                update(a, b);
            } else {
                System.out.println(sum(a, (int)b));
            }
        }

    }

    static void update(int a, long b) {
        a = (int) Math.pow(2, k) + a - 1;
        long value = b - tree[a];
        while(a != 0) {
            tree[a] = tree[a] + value;
            a = (int) Math.floor(a/2);
        }
    }

    static long sum(int a, int b) {
        int start = (int) Math.pow(2, k) + a - 1;
        int end = (int) Math.pow(2, k) + b - 1;
        long sum = 0;

        while(start <= end) {
            if(start % 2 == 1)
                sum += tree[start];
            if(end % 2 == 0)
                sum += tree[end];

            start = (start+1)/2;
            end = (end-1)/2;
        }

        return sum;
    }
}
