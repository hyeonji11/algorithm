package Level1;

public class MiddleString {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        if(len % 2 == 0) {
            answer = s.substring(len/2-1, len/2+1);
        } else {
            answer = s.substring(len/2, len/2+1);
        }
        return answer;
    }
    public static void main(String[] args) {
        MiddleString ms = new MiddleString();
        System.out.println(ms.solution("qwer"));
    }
}
