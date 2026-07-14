package SlidingWindow;

public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int zero = 0;
        int start = 0;
        int sum = 0;
        int max = sum;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] == 1) {
                sum++;
            } else if(nums[i] == 0 && zero < k) {
                sum++;
                zero++;
            } else {
                while(zero >= k) {
                    if(nums[start] == 0) {
                        zero--;
                    }
                    start++;
                    sum--;
                }
                zero++;
                sum++;
            }

            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes3 c = new MaxConsecutiveOnes3();
        System.out.println(c.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
}
