package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        for(int i=0; i<test; i++) {
            int num = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][num];
            int[][] dp = new int[2][num];

            for(int j=0; j<2; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<num; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            if(num >= 2) {
                dp[0][1] = arr[0][1]+dp[1][0];
                dp[1][1] = arr[1][1]+dp[0][0];
            }

            for(int j=2; j<num; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
            }

            sb.append(Math.max(dp[0][num-1], dp[1][num-1])).append("\n");
        }
        System.out.println(sb);
    }
}
