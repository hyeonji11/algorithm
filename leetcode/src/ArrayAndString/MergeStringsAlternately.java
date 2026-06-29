package ArrayAndString;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int shortLen = word1.length() < word2.length() ? word1.length() : word2.length();

        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<shortLen; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }

        if(word1.length() > shortLen) {
            sb.append(word1.substring(shortLen, word1.length()));
        }
        if(word2.length() > shortLen) {
            sb.append(word2.substring(shortLen, word2.length()));
        }

        return sb.toString();
    }
}
