package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String target = br.readLine();
        int len = target.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();


        for(int i=0; i<str.length(); i++) {
            stack.push(str.charAt(i));
            if(stack.size() >= len) {
                boolean flag = true;
                for(int j=1; j<=len; j++) {
                    if(stack.get(stack.size() - j) != target.charAt(len-j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j=0; j<len; j++) {
                        stack.pop();
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
