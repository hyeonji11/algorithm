package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int num1 = 0, num2 = 0;
        int start = 0, end = num-1;
        int ans = Integer.MAX_VALUE;
        int val = 0;
        int abs = 0;

        while(start<end) {
            val = arr[start] + arr[end];
            abs = Math.abs(val);
            if(abs < ans) {
                num1 = arr[start];
                num2 = arr[end];
                ans = abs;
            }

            if(val < 0) {
                start++;
            } else {
                end--;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num1).append(" ").append(num2);

        System.out.println(sb);
    }
}
