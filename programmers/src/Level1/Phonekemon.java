package Level1;

import java.util.HashSet;

public class Phonekemon {
    public int solution(int[] nums) {
        int answer = 0;

        //int[] resultArr = Arrays.stream(nums).distinct().toArray(int[]::new);

        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            hs.add(nums[i]);
        }

        int num = hs.size();
        int len = nums.length/2;
        answer = len <= num ? len : num;



        return answer;
    }
    public static void main(String[] args) {

    }
}
