package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        int index = 0;
        Stack<Character> stack = new Stack<>();
        while(index < str.length()) {
            if(str.charAt(index) == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                while(str.charAt(index) != '>') {
                    sb.append(str.charAt(index++));
                }
                sb.append(str.charAt(index++));
            } else if(str.charAt(index) == ' ') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
                index++;
            } else {
                stack.push(str.charAt(index++));
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
