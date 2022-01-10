package Level1;

public class MissingNumberSum {
    public int solution(int[] numbers) {
        int answer = 45;
        for(int i=0; i<numbers.length; i++) {
            answer -= numbers[i];
        }

        return answer;
    }
    public static void main(String[] args) {
        MissingNumberSum test = new MissingNumberSum();
        System.out.println(test.solution(new int[]{1, 4, 6, 3, 2, 5, 7}));
    }
}
