package Level1;

public class NumberStringEnglish {
    public int solution(String s) {
        int answer = 0;
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder sb = new StringBuilder("");

        while(s.length() > 0) {
            if(Character.isDigit(s.charAt(0))) {
                sb.append(s.charAt(0));
                s = s.substring(1, s.length());
                continue;
            }
            for(int i=0; i<numbers.length; i++) {
                if(s.startsWith(numbers[i])) {
                    s = s.substring(numbers[i].length(), s.length());
                    sb.append(i);
                    break;
                }
            }
        }

        answer = Integer.parseInt(sb.toString());
        return answer;
    }
    public static void main(String[] args) {
        NumberStringEnglish ns = new NumberStringEnglish();
        System.out.println(ns.solution("one4seveneight"));
    }
}
