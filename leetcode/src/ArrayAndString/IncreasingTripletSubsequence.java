package ArrayAndString;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        boolean isExist = false;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= first) {
                first = nums[i];
            } else if(nums[i] <= second) {
                second = nums[i];
            } else {
                isExist = true;
                break;
            }
        }

        return isExist;
    }
}
