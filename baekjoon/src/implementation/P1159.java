package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[26];
        boolean isFive = false;

        for(int i=0; i<num; i++) {
            String str = br.readLine();
            arr[str.charAt(0)-'a']++;
        }

        for(int i=0; i<26; i++) {
            if(arr[i] >= 5) {
                isFive = true;
                System.out.print((char)(i+97));
            }
        }
        if(!isFive) System.out.println("PREDAJA");
    }
}
