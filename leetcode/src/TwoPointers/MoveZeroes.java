package TwoPointers;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;

        for(int j=0; j<nums.length; j++) {
            if(nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        m.moveZeroes(new int[]{4,2,4,0,0,3,0,5,1,0});
    }
}
