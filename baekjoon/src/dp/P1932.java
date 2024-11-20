package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int[][] arr = new int[num][];
        int[][] dp = new int[num][];

        for(int i=0; i<num; i++) {
            arr[i] = new int[i+1];
            dp[i] = new int[i+1];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        for(int i=0; i<num-1; i++) {
            for(int j=0; j<arr[i].length; j++) {
                dp[i+1][j] = Math.max(dp[i][j] + arr[i+1][j], dp[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i][j] + arr[i+1][j+1], dp[i+1][j+1]);
            }
        }
        int max = -1;
        for(int i=0; i<num; i++) {
            max = Math.max(dp[num-1][i], max);
        }

        System.out.println(max);
    }
}
