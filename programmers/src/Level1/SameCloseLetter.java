package Level1;

import java.util.Arrays;

public class SameCloseLetter {
    static public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alpa = new int[26];
        Arrays.fill(alpa, -1);

        for(int i=0; i<s.length(); i++) {
            char cha = s.charAt(i);
            if(alpa[cha-'a'] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i-alpa[cha-'a'];
            }
            alpa[cha-'a'] = i;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = solution("banana");
        for(int val : arr) {
            System.out.println(val);
        }
    }
}
