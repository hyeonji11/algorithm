package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int space;
        for(int i=num; i>=1; i--) {
            space = num-i;
            sb.append(" ".repeat(space)).append("*".repeat(i)).append("\n");
        }

        System.out.println(sb);
    }
}
