package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int arr[] = new int[10];
        StringBuilder sb = new StringBuilder();

        String result = String.valueOf(a*b*c);

        for(int i=0; i<result.length(); i++) {
            arr[result.charAt(i)-'0']++;
        }

        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);

    }
}
