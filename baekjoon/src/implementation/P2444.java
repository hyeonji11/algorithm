package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int len = num*2 - 1;
        int cnt, val;

        for(int i=1; i<=num; i++) {
            cnt = 2*i -1;
            val = (len - cnt)/2;
            for(int j=0; j<val; j++) {
                sb.append(" ");
            }

            for(int j=0; j<cnt; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i=2; i<=num; i++) {
            cnt = 2*(num-i+1) -1;
            val = (len - cnt)/2;
            for(int j=0; j<val; j++) {
                sb.append(" ");
            }

            for(int j=0; j<cnt; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
