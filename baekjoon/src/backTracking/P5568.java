package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P5568 {
    static int n, k;
    static int[] arr;
    static int[] res;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];
        res = new int[k];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0);

        System.out.println(set.size());
    }

    static void dfs(int depth) {
        if(depth == k) {
            for(int val : res) {
                sb.append(val);
            }
            set.add(sb.toString());
            sb.setLength(0);
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                res[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
