package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int[] numArr = new int[Integer.parseInt(st.nextToken())];
        int day = Integer.parseInt(st.nextToken());
        int[] sumArr = new int[numArr.length - day +1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numArr.length; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<day; i++) {
            sumArr[0] += numArr[i];
        }

        int max = sumArr[0];
        for(int i=day; i<numArr.length; i++) {
            sumArr[i-day+1] = sumArr[i-day] - numArr[i-day] + numArr[i];
            max = Math.max(max, sumArr[i-day+1]);
        }

        System.out.println(max);
    }
}
