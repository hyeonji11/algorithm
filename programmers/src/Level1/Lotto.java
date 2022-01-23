package Level1;

import java.util.Arrays;

public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] ranking = {6, 6, 5, 4, 3, 2, 1};
        int zeroNum = 0, cnt = 0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int i=0, j=0;
        while(i<lottos.length && j<win_nums.length) {
            if(lottos[i] == 0) {
                zeroNum++;
                i++;
                continue;
            }
            if(lottos[i] == win_nums[j]) {
                cnt++;
                i++;
                j++;
            } else if(lottos[i] < win_nums[j]) {
                i++;
            } else {
                j++;
            }
        }

        answer[0] = ranking[cnt+zeroNum];
        answer[1] = ranking[cnt];

        return answer;
    }
    public static void main(String[] args) {

    }
}
