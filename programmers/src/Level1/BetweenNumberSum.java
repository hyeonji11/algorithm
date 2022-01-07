package Level1;

public class BetweenNumberSum {
    public long solution(int a, int b) {
        long answer = 0;

        int max = a > b ? a : b;
        int min = a < b ? a : b;

        while(min != max) {
            answer += max;
            max--;
        }
        answer += min;

        return answer;
    }
    public static void main(String[] args) {

    }
}
