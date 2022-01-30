package Level2;

import java.util.Arrays;

public class MakeMin {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int len = B.length-1;

        for(int i=0; i<A.length; i++) {
            answer += A[i]*B[len-i];
        }

        return answer;
    }
    public static void main(String[] args) {

    }
}
