package Level3;

import java.util.Arrays;

public class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int aIdx = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<B.length; i++) {
             if(A[aIdx] < B[i]) {
                 answer++;
                 aIdx++;
             }
        }

        return answer;
    }
    public static void main(String[] args) {
        NumberGame ng = new NumberGame();
        System.out.println(ng.solution(new int[] {2, 2, 2, 2}, new int[] {1, 1, 1, 1}));
    }
}
