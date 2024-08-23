package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int total = num*2;

        StringBuilder sb = new StringBuilder();

        int cnt;
        for(int i=1; i<=num; i++) {
            cnt = total - i*2;

            for(int j=0; j<i; j++) {
                sb.append("*");
            }
            for(int j=0; j<cnt; j++) {
                sb.append(" ");
            }
            for(int j=0; j<i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i=num-1; i>0; i--) {
            cnt = total - i*2;

            for(int j=0; j<i; j++) {
                sb.append("*");
            }
            for(int j=0; j<cnt; j++) {
                sb.append(" ");
            }
            for(int j=0; j<i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
