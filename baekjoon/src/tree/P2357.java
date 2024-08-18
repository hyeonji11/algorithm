package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2357 {
    static int s;
    static int[] minTree;
    static int[] maxTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());

        int k = (int) Math.ceil(Math.log(num)/Math.log(2));
        s = (int) Math.pow(2, k);

        minTree = new int[s*2];
        maxTree = new int[s*2];

        for(int i = s; i < s+num; i++) {
            minTree[i] = Integer.parseInt(br.readLine());
            maxTree[i] = minTree[i];
        }

        int last = s+num-1;

        if(last % 2 == 0) {
            minTree[last/2] = minTree[last];
            maxTree[last/2] = maxTree[last];
            last--;
        }

        for(int i = last; i>1; i -= 2) {
            minTree[i/2] = Math.min(minTree[i], minTree[i-1]);
            maxTree[i/2] = Math.max(maxTree[i], maxTree[i-1]);
        }

        int a, b;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<testCase; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(min(a, b)).append(" ").append(max(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    static int min(int a, int b) {
        int start = s + a - 1;
        int end = s + b - 1;
        int min = Integer.MAX_VALUE;

        while(start <= end) {
            if(start % 2 == 1)
                min = Math.min(min, minTree[start]);
            if(end % 2 == 0)
                min = Math.min(min, minTree[end]);

            start = (start+1)/2;
            end = (end-1)/2;
        }

        return min;
    }

    static int max(int a, int b) {
        int start = s + a - 1;
        int end = s + b - 1;
        int max = 0;

        while(start <= end) {
            if(start % 2 == 1)
                max = Math.max(max, maxTree[start]);
            if(end % 2 == 0)
                max = Math.max(max, maxTree[end]);

            start = (start+1)/2;
            end = (end-1)/2;
        }

        return max;
    }
}
