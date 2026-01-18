package Level3;

import java.util.Arrays;

public class TheBestSet {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int num = s/n;
        if(num < 1) return new int[] {-1};

        int count = s%n;

        for(int i = n-1; i >= 0; i--) {
            if(count > 0) {
                answer[i] = num+1;
                count--;
            } else {
                answer[i] = num;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TheBestSet().solution(2, 9)));
        System.out.println(Arrays.toString(new TheBestSet().solution(2, 1)));
        System.out.println(Arrays.toString(new TheBestSet().solution(2, 8)));
        System.out.println(Arrays.toString(new TheBestSet().solution(3, 49)));
        System.out.println(Arrays.toString(new TheBestSet().solution(4, 50)));
    }
}
