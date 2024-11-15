package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringBuilder str = new StringBuilder();

        for(int i=0; i<num; i++) {
            str.append(br.readLine());

            int start = 0, end = str.length()-1;
            int palindrome = 0;
            while(start < end && palindrome < 2) {
                if(str.charAt(start) == str.charAt(end)) {
                    start++;
                    end--;
                    continue;
                }
                if(isPalindrome(str.toString(), start+1, end) || isPalindrome(str.toString(), start, end-1)) {
                    palindrome = 1;
                    break;
                } else {
                    palindrome = 2;
                }
            }
            sb.append(palindrome).append("\n");
            str.setLength(0);
        }

        System.out.println(sb);
    }

    static boolean isPalindrome(String s, int left, int right) {
        boolean isPalindrome = true;
        while(left < right && isPalindrome) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            isPalindrome = false;
        }
        return isPalindrome;
    }
}
