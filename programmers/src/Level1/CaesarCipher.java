package Level1;

public class CaesarCipher {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)) {
                if(ch + n > 90) {
                    sb.append((char)(64+ch+n-90));
                } else {
                    sb.append((char)(ch+n));
                }
            } else if(Character.isLowerCase(ch)) {
                if(ch + n > 122) {
                    sb.append((char)(96+ch+n-122));
                } else {
                    sb.append((char)(ch+n));
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher();
        cc.solution("AB", 1);
    }
}
