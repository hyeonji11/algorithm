package Level1;

import java.util.ArrayList;

public class TernaryNotationReverse {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(n>0) {
            list.add(n%3);
            n = n/3;
        }

        for(int i=list.size()-1; i>=0; i--) {
            answer += Math.pow(3, list.size()-i-1)*list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        TernaryNotationReverse t = new TernaryNotationReverse();
        System.out.println(t.solution(125));
    }
}
