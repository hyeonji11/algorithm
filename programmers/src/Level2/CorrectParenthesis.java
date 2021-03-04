package Level2;

import java.util.Stack;

public class CorrectParenthesis {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack();
        for(int i=0; i<s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if(s.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
    public static void main(String[] args) {
        CorrectParenthesis cp = new CorrectParenthesis();
        System.out.println(cp.solution("(()("));
    }
}
