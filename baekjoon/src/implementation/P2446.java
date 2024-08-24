package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=num; i>=1; i--) {
            for(int j=0; j<num-i; j++) {
                sb.append(" ");
            }
            for(int j=0; j<i*2-1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for(int i=2; i<=num; i++) {
            for(int j=0; j<num-i; j++) {
                sb.append(" ");
            }
            for(int j=0; j<i*2-1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
