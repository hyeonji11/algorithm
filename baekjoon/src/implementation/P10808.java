package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int[] arr = new int[26];

        for(int i=0; i<str.length(); i++) {
            arr[str.charAt(i)-'a']++;
        }
        for(int i=0; i<25; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append(arr[25]);
        System.out.println(sb);

    }
}
