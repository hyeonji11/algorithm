package Level2;

import java.util.ArrayList;
import java.util.HashSet;

public class FindPrimeNumber {
    static void dfs() {

    }
    public int solution(String numbers) {
        int answer = 0;

        String[] numArr = numbers.split("");
        HashSet<Integer> hs = new HashSet<>();


        //소수인지 아닌지
        for(int num : hs) {
            if(num%2 == 0) continue;
            answer++;
            for(int i=3; i<num; i += 2) {
                if(num%i == 0) {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        FindPrimeNumber pm = new FindPrimeNumber();
        System.out.println(pm.solution("17"));
    }
}
