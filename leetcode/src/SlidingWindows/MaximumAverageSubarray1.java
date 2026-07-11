package SlidingWindows;

public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for(int i=0; i<k; i++) {
            sum += nums[i];
        }
        int max = sum;

        int start = 0;
        for(int i=k; i<nums.length; i++) {
            sum = sum - nums[start] + nums[i];
            max = Math.max(sum, max);
            start++;
        }

        return max/(double)k;
    }
}
