package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P15663 {

    static int n, m;
    static int[] arr;
    static int[] res;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        arr = new int[n];
        res = new int[m];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backTracking(0);

        System.out.println(sb);
    }

    static void backTracking(int depth) {
        if(depth == m) {
            for(int val : res) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        int num = 0;

        for(int i=0; i<n; i++) {
            if(!visited[i] && num != arr[i]) {
                visited[i] = true;
                res[depth] = arr[i];
                num = arr[i];
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }
}
