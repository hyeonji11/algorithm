package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] stamina = new int[n+1];
        int[] joy =  new int[n+1];
        int[][] dp = new int[n+1][100];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            stamina[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=99; j++) {
                if(stamina[i] <= j) {
                    dp[i][j] = Math.max(joy[i]+dp[i-1][j-stamina[i]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][99]);
    }
}
