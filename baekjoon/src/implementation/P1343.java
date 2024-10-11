package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '.') {
                if(cnt != 0) {
                    sb.append("AAAA".repeat(cnt/4));
                    cnt %= 4;
                    if(cnt == 2) {
                        sb.append("BB");
                        cnt = 0;
                    } else if(cnt % 2 != 0) {
                        System.out.println("-1");
                        return;
                    }
                }
                sb.append(".");
            } else {
                cnt++;
            }
        }

        sb.append("AAAA".repeat(cnt/4));
        cnt %= 4;
        if(cnt == 2) {
            sb.append("BB");
            cnt = 0;
        }

        if(cnt == 0)
            System.out.println(sb);
        else System.out.println("-1");

//        if(cnt != 0) {
//            sb.append("AAAA".repeat(cnt/4));
//            cnt %= 4;
//            if(cnt == 2) {
//                sb.append("BB");
//            } else {
//                System.out.println("-1");
//                return;
//            }
//        }
//        System.out.println(sb);

    }
}
