package Level1;

public class StringCare {
    public boolean solution(String s) {
        boolean answer = true;
        String regex = "[0-9]+";
        if(s.length() != 4 && s.length() != 6) {
            return !answer;
        }
        if(s.matches(regex)) {
            return answer;
        } else {
            return !answer;
        }
    }

    public static void main(String[] args) {

    }
}
