package Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class DividedNumberArray {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        if(list.size() == 0) {
            return new int[] {-1};
        }
        answer = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        DividedNumberArray dna = new DividedNumberArray();
    }
}
