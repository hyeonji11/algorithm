package Level1;

public class MissingAmountCalculation {
    public long solution(int price, int money, int count) {
        long answer = 0;

        while(count > 0) {
            answer += price * count--;
        }

        if(money < answer) return answer - money;

        return 0;
    }
}
