package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int[] arr = new int[10];

        for(int i=0; i<num.length(); i++) {
            arr[num.charAt(i)-'0']++;
        }

        int max = 0;

        arr[6] = (arr[6] + arr[9])/2 + (arr[6] + arr[9])%2;
        arr[9] = 0;
        for(int i=0; i<9; i++) {
            max = Math.max(max, arr[i]);
        }

        System.out.print(max);
    }
}
