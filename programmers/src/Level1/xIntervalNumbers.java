package Level1;

public class xIntervalNumbers {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = x;
        for(int i=0; i<n; i++) {
            answer[i] = num;
            num += x;
        }
        return answer;
    }
    public static void main(String[] args) {
        xIntervalNumbers xin = new xIntervalNumbers();
        xin.solution(-4, 2);
    }
}
