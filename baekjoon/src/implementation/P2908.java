package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        StringBuilder str1 = new StringBuilder(inputs[0]);
        StringBuilder str2 = new StringBuilder(inputs[1]);

        int num1 = Integer.parseInt(str1.reverse().toString());
        int num2 = Integer.parseInt(str2.reverse().toString());

        if(num1 > num2)
            System.out.println(num1);
        else
            System.out.println(num2);
    }
}
