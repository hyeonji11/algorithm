package Level2;

import java.util.StringTokenizer;

public class JadenCase {
    public String solution(String s) {
        String str;
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder("");

        while(st.hasMoreTokens()) {
            str = st.nextToken().toLowerCase();
            if(!Character.isDigit(str.charAt(0))) {
                sb.append(str.substring(0,1).toUpperCase());
                sb.append(str.substring(1, str.length())+" ");
            } else {
                sb.append(str+" ");
            }
        }
        return sb.toString().trim();
    }
}
