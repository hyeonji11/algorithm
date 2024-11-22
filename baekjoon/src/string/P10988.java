package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int left = 0, right = str.length()-1;
        int isPalindrome = 1;

        while(left<right) {
            if(str.charAt(left) != str.charAt(right)) {
                isPalindrome = 0;
                break;
            }
            left++;
            right--;
        }

        System.out.println(isPalindrome);
    }
}
