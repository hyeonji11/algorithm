package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10995 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=num; i++) {
            if(i % 2 == 1) {
                sb.append("* ".repeat(num-1));
                sb.append("*").append("\n");
            } else {
                sb.append(" *".repeat(num)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
