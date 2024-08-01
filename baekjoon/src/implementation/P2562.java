package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int index = -1;
        for(int i=1; i<=9; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > max) {
                max = num;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}
