package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11726 {
    static int[] arr = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        arr[1] = 1;
        arr[2] = 2;

        System.out.println(dp(num));
    }
    public static int dp(int n) {
        if(arr[n] != 0)
            return arr[n];
        else {
            arr[n] = (dp(n-1) + dp(n-2)) % 10007;
            return arr[n];
        }

    }
}
