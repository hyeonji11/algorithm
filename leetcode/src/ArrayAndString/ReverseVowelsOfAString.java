package ArrayAndString;

import java.util.ArrayList;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] chArr = s.toCharArray();

        int left = 0;
        int right = s.length()-1;

        char temp;

        while(left < right) {
            if(!isVowels(chArr[left])) {
                left++;
            } else if(!isVowels(chArr[right])) {
                right--;
            }
            else {
                temp = chArr[left];
                chArr[left] = chArr[right];
                chArr[right] = temp;
                left++;
                right--;
            }

        }

        return new String(chArr);
    }

    public boolean isVowels(char ch) {
        switch(ch) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
            case 'A': case 'E': case 'I': case 'O': case 'U':
                return true;
            default:
                return false;
        }
    }

    // replace()가 내부에서 arraycopy 호출로 매번 복사가 일어남.
    // 모음 하나 교체할 때마다 O(n) 모음 n개면 O(n^2)
    /*
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);

        String vowels = "aeiouAEIOU";
        ArrayList<Character> chList = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            if(vowels.indexOf(s.charAt(i)) != -1) {
                chList.add(s.charAt(i));
            }
        }

        int count = chList.size()-1;
        for(int i=0; i<sb.length(); i++) {
            if(vowels.indexOf(sb.charAt(i)) != -1) {
                sb.replace(i, i+1, chList.get(count--).toString());
            }
        }

        return sb.toString();

    }

     */
}
