package Level1;

public class EvenOdd {
    public String solution(int num) {
        String answer = "";
        if(num % 2 == 0) {
            answer = "Even";
        } else {
            answer = "Odd";
        }
        return answer;
    }
    public static void main(String[] args) {
        EvenOdd eo = new EvenOdd();
        System.out.println(eo.solution(3));
    }
}
