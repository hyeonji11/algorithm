package Level1;

public class Collatz {
    public int solution(long num) {
        int answer = 0;
        while(num != 1) {
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num = num*3 + 1;
            }
            answer++;
            if(answer == 500) return -1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Collatz co = new Collatz();
        System.out.println(co.solution(626331));
    }
}
