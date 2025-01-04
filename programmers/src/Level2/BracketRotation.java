package Level2;

import java.util.HashMap;
import java.util.Stack;

public class BracketRotation {
    HashMap<Character, Character> map = new HashMap<>();
    public int solution(String s) {
        int answer = 0;
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++) {
            if(checkBracket(sb.toString()))
                answer++;
            sb.append(sb.substring(0, 1));
            sb.delete(0, 1);
        }
        return answer;
    }

    public boolean checkBracket(String str) {
        boolean isCorrect = true;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if(stack.isEmpty() || stack.peek() != map.get(ch)) {
                    isCorrect = false;
                    break;
                }
                stack.pop();
            }
        }
        if(stack.size() != 0)
            isCorrect = false;

        return isCorrect;
    }
    public static void main(String[] args) {
        BracketRotation br = new BracketRotation();
        System.out.println(br.solution("(]"));
    }
}
