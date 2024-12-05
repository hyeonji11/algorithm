package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] students = new boolean[31];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<28; i++) {
            students[Integer.parseInt(br.readLine())] = true;
        }
        for(int i=1; i<=30; i++) {
            if(!students[i])
                sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
