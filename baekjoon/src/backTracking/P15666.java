package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15666 {
    static int n, m;
    static int[] arr;
    static int[] res;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        res = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backTracking(0, 0);
        System.out.println(sb);
    }

    static void backTracking(int depth, int start) {
        if(depth == m) {
            for(int val : res) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int num = 0;
        for(int i=start; i<n; i++) {
            if(num != arr[i]) {
                num = arr[i];
                res[depth] = arr[i];
                backTracking(depth+1, i);
            }
        }
    }
}
