package Level1;

public class MakeStrangeCharacter {
    static public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        int index = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer.append(' ');
                index = 0;
                continue;
            }
            if(index % 2 == 0) {
                answer.append(String.valueOf(s.charAt(i)).toUpperCase());
            } else {
                answer.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
            index++;
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }
}
