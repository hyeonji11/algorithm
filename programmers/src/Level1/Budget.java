package Level1;

import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
/*
        for(int i=0; i<d.length; i++) {
            if(budget-d[i] >= 0) {
                budget -= d[i];
                answer++;
            } else break;
        }

 */
        for(int i=0; i<d.length; i++) {
            budget -= d[i];
            if(budget < 0) break;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Budget b = new Budget();
        System.out.println(b.solution(new int[] {1, 3, 2, 5, 4}, 9));
    }
}
