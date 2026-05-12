package Level2;

import java.util.Arrays;

public class NumberConversion {
    public int solution(int x, int y, int n) {

        int[] dp = new int[y + 1];
        Arrays.fill(dp, 1000000);

        dp[x] = 0;

        for(int i = x+1; i <= y; i++) {
            if(i%3 == 0 && i/3 >= x) dp[i] = dp[i/3];
            if(i%2 == 0 && i/2 >= x) dp[i] = Math.min(dp[i], dp[i/2]);
            if(i-n >= x) dp[i] = Math.min(dp[i], dp[i-n]);
            dp[i]++;
        }

        if(dp[y] >= 1000000) return -1;

        return dp[y];
    }

    public static void main(String[] args) {
        System.out.println(new NumberConversion().solution(38,40,2));
        System.out.println(new NumberConversion().solution(8,144,32));
        System.out.println(new NumberConversion().solution(8,134,32));
    }
}
