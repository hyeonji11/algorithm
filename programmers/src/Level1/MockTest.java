package Level1;

import java.util.Arrays;

public class MockTest {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];

        int[][] pattern = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        int count = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<answers.length; j++) {
                if(answers[j] == pattern[i][count]) {
                    answer[i]++;
                }
                count++;
                if(count == pattern[i].length)
                    count = 0;
            }
            count = 0;
        }

        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        int[] result = new int[3];

        for(int i=0; i<3; i++) {
            if(max == answer[i]) {
                result[count] = i+1;
                count++;
            }
        }

        return Arrays.copyOf(result, count);
    }

    public static void main(String[] args) {
        MockTest mt = new MockTest();
        int[] answers = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] result = mt.solution(answers);
        for(int num: result) {
            System.out.println(num);
        }
    }
}
