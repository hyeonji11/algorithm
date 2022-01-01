package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 0;
        int min = 0;
        int minus;

        for(int i=2; i<=num; i++) {
            int two = Integer.MAX_VALUE;
            int three = Integer.MAX_VALUE;

            if(i%3 == 0) three = dp[i/3];
            if(i%2 == 0) two = dp[i/2];
            minus = dp[i-1];
            min = Math.min(minus, Math.min(two, three));
            dp[i] = min + 1;
        }

        System.out.println(dp[num]);
    }
}
