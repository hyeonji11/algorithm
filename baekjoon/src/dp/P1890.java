package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1890 {

    static int[][] graph;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());

        graph = new int[size][size];
        dp = new long[size][size];

        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<size; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dp(0, 0));


    }

    static public long dp(int x, int y) {
        if(dp[y][x] != -1) {
            return dp[y][x];
        }
        int value = graph[y][x];
        if(x == graph.length-1 && y == graph.length-1) {
            return 1;
        }
        dp[y][x] = 0;
        int nextX = x+value;
        int nextY = y+value;

        if(nextY > graph.length-1 && nextX > graph.length-1)
            return 0;

        if(nextX <= graph.length-1)
            dp[y][x] = Math.max(dp[y][x], dp[y][x] + dp(nextX, y));

        if(nextY <= graph.length-1)
            dp[y][x] = Math.max(dp[y][x], dp[y][x] + dp(x, nextY));

        return dp[y][x];
    }
}
