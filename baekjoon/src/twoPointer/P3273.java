package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3273 {
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

        int x = Integer.parseInt(br.readLine());
        int start = 0, end = num-1;
        int ans = 0;

        int val = 0;
        while(start<end) {
            val = arr[start]+arr[end];

            if(val == x) {
                ans++;
                start++;
                end--;
            } else if(val < x) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(ans);


    }
}
