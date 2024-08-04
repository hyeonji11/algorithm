package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        String str = br.readLine();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            int index = c-'a';
            if(arr[index] == -1)
                arr[index] = i;

        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
