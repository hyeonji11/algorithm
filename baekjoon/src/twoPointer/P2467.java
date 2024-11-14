package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0, end = num-1;
        int num1 = 0, num2 = 0;
        int val = 0;
        int abs = Integer.MAX_VALUE;

        while(start < end) {
            val = arr[start] + arr[end];
            if(Math.abs(val) < abs) {
                abs = Math.abs(val);
                num1 = arr[start];
                num2 = arr[end];
            }
            if(val < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(num1+" "+num2);


    }
}
