package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int cnt = str.length()/10;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i+=10) {
            if(i+10 <= str.length()) {
                sb.append(str.substring(i, i+10)).append("\n");
            } else {
                sb.append(str.substring(cnt*10, str.length()));
            }
        }

        System.out.println(sb);
    }
}
