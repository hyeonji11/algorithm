package ArrayAndString;

public class ProductOfArrayExceptSelf {
    // 나눗셈 연산을 사용하지 않고 O(1)의 시간복잡도로 풀기
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] front = new int[len];
        int[] back = new int[len];
        int[] answer = new int[len];

        front[0] = nums[0];
        for(int i=1; i<len; i++) {
            front[i] = nums[i]*front[i-1];
        }

        back[0] = nums[len-1];
        for(int i=1; i<len; i++) {
            back[i] = nums[len-1-i]*back[i-1];
        }

        answer[0] = back[len-2];
        for(int i=1; i<len-1; i++) {
            answer[i] = back[len-2-i]*front[i-1];
        }
        answer[len-1] = front[len-2];

        return answer;
    }
}
