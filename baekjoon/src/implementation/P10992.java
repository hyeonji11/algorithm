package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int space;
        int front = num-1;
        sb.append(" ".repeat(front--));
        sb.append("*").append("\n");
        for(int i=2; i<num; i++) {
            space = (i-1)*2-1;
            sb.append(" ".repeat(front--));
            sb.append("*");
            sb.append(" ".repeat(space));
            sb.append("*").append("\n");
        }

        if(num != 1) {
            sb.append("*".repeat(num*2-1));
        }
        System.out.println(sb);
    }
}
