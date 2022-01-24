package Level1;

public class ToStringFromNumberReverse {
    public int[] solution(long n) {
        String str = ""+n;
        int len = str.length();
        int[] answer = new int[len];

        for(int i=1; i<=str.length(); i++) {
            answer[len-i] = str.charAt(i-1)-'0';
        }
        return answer;
    }
    public static void main(String[] args) {
        ToStringFromNumberReverse test = new ToStringFromNumberReverse();
        test.solution(12345);
    }
}
