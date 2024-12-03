package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                sb.append(st.nextToken()).reverse();
                ans.append(sb).append(" ");
                sb.setLength(0);
            }
            ans.append("\n");

        }
        System.out.println(ans);

    }
}
