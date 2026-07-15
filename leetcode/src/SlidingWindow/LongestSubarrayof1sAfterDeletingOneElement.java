package SlidingWindow;

public class LongestSubarrayof1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int sum = 0;
        int max = 0;
        boolean isDeleted = false;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0 && !isDeleted) {
                isDeleted = true;
            } else if(nums[i] == 0 && isDeleted) {
                while(isDeleted) {
                    if(nums[start] == 0) {
                        isDeleted = false;
                    } else {
                        sum--;
                    }
                    start++;
                }
                isDeleted = true;
            } else {
                sum++;
            }

            max = Math.max(sum, max);
        }

        if(max == nums.length) max--;

        return max;
    }

    public static void main(String[] args) {
        LongestSubarrayof1sAfterDeletingOneElement l = new LongestSubarrayof1sAfterDeletingOneElement();
        System.out.println(l.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }
}
