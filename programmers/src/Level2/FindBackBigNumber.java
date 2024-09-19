package Level2;

import java.util.Stack;

public class FindBackBigNumber {
    static public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<numbers.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                while(numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                    if(stack.isEmpty()) break;
                }
                stack.push(i);
            }
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] arr = solution(new int[]{4, 8, 9, 2, 8, 3, 1, 5});
        for(int val : arr) {
            System.out.println(val);
        }
    }
}
