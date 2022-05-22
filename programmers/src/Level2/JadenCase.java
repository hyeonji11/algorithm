package Level2;

public class JadenCase {
    public static void main(String[] args) {
        JadenCase jc = new JadenCase();
        System.out.println(jc.solution("3people unFollowed me"));
    }
    public String solution(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder(str);
        boolean isFirst = true;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ' ') {
                isFirst = true;
                continue;
            }
            if(isFirst && !Character.isDigit(str.charAt(i))) {
                sb.setCharAt(i, (char) (str.charAt(i) -32));

            }
            isFirst = false;
        }
        return sb.toString();
//        String str;
//        StringTokenizer st = new StringTokenizer(s);
//        StringBuilder sb = new StringBuilder("");
//
//        while(st.hasMoreTokens()) {
//            str = st.nextToken().toLowerCase();
//            if(!Character.isDigit(str.charAt(0))) {
//                sb.append(str.substring(0,1).toUpperCase());
//                sb.append(str.substring(1, str.length())+" ");
//            } else {
//                sb.append(str+" ");
//            }
//        }
//        return sb.toString().trim();
    }
}
