package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String[] inputs;

        int num;
        for(int i=0; i<testCase; i++) {
            inputs = br.readLine().split(" ");
            num = Integer.parseInt(inputs[0]);

            StringBuilder sb = new StringBuilder();
            for(int j=0; j<inputs[1].length(); j++) {
                for(int k=0; k<num; k++) {
                    sb.append(inputs[1].charAt(j));
                }
            }
            System.out.println(sb);
        }
    }
}
