package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        String[] arr1 = expression.split("-");

        int ans = sum(arr1[0]);

        for(int i=1; i<arr1.length; i++) {
            ans -= sum(arr1[i]);
        }

        System.out.println(ans);
    }
    public static int sum(String str) {
        int total = 0;
        String[] num = str.split("\\+");
        for(int i=0; i<num.length; i++) {
            total += Integer.parseInt(num[i]);
        }
        return total;
    }
}
