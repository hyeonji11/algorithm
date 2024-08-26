package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int cnt;
        for(int i=1; i<=num; i++) {
            cnt = num-i;
            sb.append(" ".repeat(cnt));
            sb.append("*".repeat(i));
            sb.append("\n");
        }

        for(int i=num-1; i>0; i--) {
            cnt = num-i;
            sb.append(" ".repeat(cnt));
            sb.append("*".repeat(i));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
