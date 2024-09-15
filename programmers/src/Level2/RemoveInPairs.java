package Level2;

import java.util.Stack;

public class RemoveInPairs {
    static public int solution(String s)
    {
        int answer = 1;

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i=s.length()-1; i>0; i--) {
            stack1.push(s.charAt(i));
        }
        stack2.push(s.charAt(0));

        while(stack1.size() != 0) {

            if(stack2.size() == 0)
                stack2.push(stack1.pop());
            if(stack1.size() == 0) break;
            if(stack1.peek() == stack2.peek()) {
                stack1.pop();
                stack2.pop();
            } else {
                stack2.push(stack1.pop());
            }
        }

        if(stack2.size() != 0) answer = 0;

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
        System.out.println(solution("aaaaa"));
    }
}
