package Level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Phonekemon {
    public int solution(int[] nums) {
        int answer = 0;

        //Integer[] resultArr = Arrays.stream(nums).distinct().toArray(Integer[]::new);

        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            hs.add(nums[i]);
        }

        int num = hs.size();
        int len = nums.length/2;
        if(len <= num) {
            answer = len;
        } else if(len > num) {
            answer = num;
        }


        return answer;
    }
    public static void main(String[] args) {

    }
}
