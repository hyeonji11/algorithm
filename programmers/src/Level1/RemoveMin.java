package Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveMin {
    public int[] solution(int[] arr) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList(Arrays.asList(arr));

        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        if(arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

//        for(Integer i: list) {
//            System.out.println(i);
//        }
        System.out.println(list);

        for(int i=0; i<arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
                minIdx = i;
                System.out.println("min: "+min);
            }
        }

        list.remove(minIdx);
        answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
    public static void main(String[] args) {
        RemoveMin rm = new RemoveMin();
        System.out.println(rm.solution(new int[] {4, 6, 1, 3})[0]);
    }
}
