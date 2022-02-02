package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int start = 0, end = 0;

        st = new StringTokenizer(br.readLine());
        int[] numArr = new int[Integer.parseInt(st.nextToken())];
        int[] sumArr = new int[numArr.length];
        int cnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numArr[0] = Integer.parseInt(st.nextToken());
        sumArr[0] = numArr[0];
        for(int i=1; i<numArr.length; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = numArr[i] + sumArr[i-1];
        }


        for(int i=0; i<cnt; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken())-1;
            end = Integer.parseInt(st.nextToken())-1;
            if(start == 0) {
                System.out.println(sumArr[end]);
            } else {
                System.out.println(sumArr[end] - sumArr[start-1]);
            }
        }


    }
}
