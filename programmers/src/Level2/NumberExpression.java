package Level2;

public class NumberExpression {
    static public int solution(int n) {
        int answer = 0;

        int sum;
        for(int i=1; i<=n; i++) {
            sum = i;
            int cnt = 1;
            while(sum < n) {
                sum += i+cnt;
                cnt++;
            }
            if(sum == n) answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
