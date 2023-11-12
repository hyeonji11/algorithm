package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[len];
        for(int i=0; i<len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start = 0, end = len-1, count = 0;

        while(start < end) {
//            int sum = arr[start] + arr[end];
            if(arr[start] + arr[end] > num)
                end--;
            else if(arr[start] + arr[end] < num)
                start++;
            else {
                count++;
                start++;
                end--;
            }
        }

        System.out.println(count);
    }
}
