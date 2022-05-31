package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int[] numArr = new int[len];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<len; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = len-1;
            int mid = 0;
            boolean flag = false;

            while(start<=end) {
                mid = (start+end) / 2;
                if(val > numArr[mid]) {
                    start = mid+1;
                } else if(val < numArr[mid]) {
                    end = mid-1;
                } else {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag? 1: 0);
        }

    }
}
