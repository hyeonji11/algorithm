package Level2;

import java.util.*;

public class TangerinePick {
    static public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<tangerine.length; i++) {
            int val = map.getOrDefault(tangerine[i], 0);
            map.put(tangerine[i], val+1);
        }

        int[] arr = map.values().stream()
                .mapToInt(Integer::intValue)
                .toArray();

        Arrays.sort(arr);

        for(int i=arr.length-1; i>=0; i--) {
            k -= arr[i];
            answer++;

            if(k <= 0) {
                break;
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }
}
