package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10868 {
    static int s;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());

        int k = (int) Math.ceil(Math.log(num)/Math.log(2));
        s = (int) Math.pow(2, k);

        tree = new int[s*2];

        for(int i = s; i < s+num; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int last = s+num-1;

        if(last % 2 == 0) {
            tree[last/2] = tree[last];
            last--;
        }

        for(int i = last; i>1; i -= 2) {
            tree[i/2] = Math.min(tree[i], tree[i-1]);
        }

        int a, b;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<testCase; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(min(a, b)).append("\n");
        }
        System.out.println(sb);

    }

    static int min(int a, int b) {
        int start = s + a - 1;
        int end = s + b - 1;
        int min = Integer.MAX_VALUE;

        while(start <= end) {
            if(start % 2 == 1)
                min = Math.min(min, tree[start]);
            if(end % 2 == 0)
                min = Math.min(min, tree[end]);

            start = (start+1)/2;
            end = (end-1)/2;
        }

        return min;
    }
}
