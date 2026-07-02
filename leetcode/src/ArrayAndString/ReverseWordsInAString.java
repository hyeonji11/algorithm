package ArrayAndString;

import java.util.StringTokenizer;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder result = new StringBuilder("");

        while(st.hasMoreTokens()) {
            result.insert(0, st.nextToken()+" ");
        }

        return result.substring(0, result.length()-1);
    }
}
