package Level2;

import java.util.Stack;

public class PeranthesisTransformation {
    public String solution(String p) {
        String answer = "";

        int count1 = 0;
        int count2 = 0;
        String u = "";
        String v = "";

        if(isRight(p)) return answer=p;

        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(')
                count1++;
            else
                count2++;

            if(count1 == count2) {
                u = p.substring(0, i+1);
                v = p.substring(i+1, p.length());
                break;
            }
        }

        if(isRight(u)) { // u가 올바른 괄호 문자열일때 v에 대해 1단계부터 수행

        }
        return answer;
    }

    public boolean isRight(String str) {//올바른 괄호 문자열인지 체크하는 메소드
        Stack<String> s = new Stack<String>();

        for(int i=0; i<str.length(); i++) {
            if(s.empty()) {
                s.push(str.substring(i, i+1));
            } else {
                if(s.peek().equals("(")) {
                    if(str.substring(i, i+1).equals(")")) {
                        s.pop();
                    } else {
                        s.push(str.substring(i, i+1));
                    }
                } else {
                    s.push(str.substring(i, i+1));
                }

            }

        }

        if(s.empty()) {
            System.out.println("올바른 괄호 문자열");
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        PeranthesisTransformation pt = new PeranthesisTransformation();
        pt.solution("()))((()");

    }
}
