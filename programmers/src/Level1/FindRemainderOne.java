package Level1;

public class FindRemainderOne {
    public int solution(int n) {
        int answer = 0;

        for(int i=2; i<n; i++) {
            if(n%i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        FindRemainderOne test = new FindRemainderOne();
        System.out.println(test.solution(8));
    }
}
