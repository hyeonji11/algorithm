package Level1;

import java.util.Arrays;
import java.util.HashSet;

public class TwoNumberSum {
    public int[] solution(int[] numbers) {
        int[] answer;
        int index=0;
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=0; j<numbers.length; j++) {
                if(i==j) continue;
                hs.add(numbers[i]+numbers[j]);
            }
        }

        answer = new int[hs.size()];

        for(int num: hs) {
            answer[index] = num;
            index++;
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        TwoNumberSum t = new TwoNumberSum();
        int[] numbers = {5,0,2,7};
        t.solution(numbers);
    }
}
