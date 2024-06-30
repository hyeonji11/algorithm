package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int ans = 0;

        String first = br.readLine();

        for(int i=0; i<num-1; i++) {
            String str = br.readLine();
            int cnt = 0;
            int[] word = new int[26];
            for(int j=0; j<first.length(); j++) {
                word[first.charAt(j) - 'A']++;
            }

            for(int j=0; j<str.length(); j++) {
                if(word[str.charAt(j) - 'A'] > 0) {
                    cnt++;
                    word[str.charAt(j) - 'A']--;
                }
            }

            if(first.length() == str.length() && (first.length() == cnt || first.length() - 1 == cnt)) {
                ans++;
            }
            else if (first.length() == str.length() - 1 && str.length() - 1 == cnt) {
                ans++;
            }
            else if (first.length() == str.length() + 1 && str.length() == cnt) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
