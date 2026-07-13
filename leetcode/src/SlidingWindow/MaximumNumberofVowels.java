package SlidingWindow;

public class MaximumNumberofVowels {
    public int maxVowels(String s, int k) {
        int[] isVowels = new int[s.length()];

        int sum = 0;

        for(int i=0; i<k; i++) {
            if(isVowel(s.charAt(i))) {
                isVowels[i] = 1;
                sum++;
            }
        }
        int max = sum;

        for(int i=k; i<s.length(); i++) {
            if(isVowel(s.charAt(i))) {
                sum++;
                isVowels[i] = 1;
            }
            sum -= isVowels[i-k];

            max = Math.max(max, sum);
        }

        return max;
    }

    public boolean isVowel(char value) {
        switch(value) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                return true;
            default:
                return false;
        }
    }
}
