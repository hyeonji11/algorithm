package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];
        int[] numArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        result[0] = numArr[0];
        int max = result[0];

        for(int i=1; i<n; i++) {
            result[i] = Math.max(result[i-1]+numArr[i], numArr[i]);
            max = Math.max(max, result[i]);
        }

        System.out.println(max);

    }
}
