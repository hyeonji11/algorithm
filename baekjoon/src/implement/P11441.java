package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int[] sumArr = new int[len];

        st = new StringTokenizer(br.readLine());
        sumArr[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<len; i++) {
            sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());

        for(int i=0; i<cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            if(start == 0) {
                System.out.println(sumArr[end]);
            } else {
                System.out.println(sumArr[end] - sumArr[start-1]);
            }
        }
    }
}
