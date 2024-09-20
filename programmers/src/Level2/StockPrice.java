package Level2;

import java.util.Stack;

public class StockPrice {
    static public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<prices.length; i++) {
            if(!stack.isEmpty()) {
                while(prices[stack.peek()] > prices[i]) {
                    int idx = stack.pop();
                    answer[idx] = i-idx;
                    if(stack.isEmpty()) break;
                }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length-idx-1;
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
