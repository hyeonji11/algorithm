package Level2;

import java.util.Arrays;

public class Lifeboat {
    static public int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        int end = people.length-1;
        Arrays.sort(people);

        while(start<end) {
            if(people[start] + people[end] <= limit) {
                answer++;
                start++;
                end--;
            } else {
                answer++;
                end--;
            }
        }
        if(start == end)
            answer++;

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }
}
