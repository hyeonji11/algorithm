package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder("");
        StringBuilder val = new StringBuilder("");
        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken());
            while(st.hasMoreTokens()) {
                val.setLength(0); // 초기화
                val.append(st.nextToken());
                if(sb.charAt(0) < val.charAt(0)) {
                    sb.append(val);
                } else {
                    sb.insert(0, val);
                }
            }
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
}
