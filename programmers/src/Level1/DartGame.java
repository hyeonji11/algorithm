package Level1;

import java.util.regex.Pattern;

public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        String[] arr = dartResult.split("");

        int[] stage = new int[3];
        int cnt=0;
        for(int i=0; i<dartResult.length(); i++) {
            if(Pattern.matches("[0-9]", arr[i])) {
                if(Integer.parseInt(arr[i]) == 0) {
                    if(i != 0 && Pattern.matches("[0-9]", arr[i-1])) {
                        stage[cnt-1] = 10;
                        continue;
                    }
                }
                stage[cnt] = Integer.parseInt(arr[i]);
                cnt++;

            } else if(Pattern.matches("[*#]", arr[i])) {
                if(arr[i].equals("*")) {
                    if(cnt == 1) {
                        stage[cnt-1] *= 2;
                    } else {
                        stage[cnt-1] *= 2;
                        stage[cnt-2] *= 2;
                    }
                } else {
                    stage[cnt-1] *= -1;
                }
            } else {
                System.out.println(arr[i].charAt(0)+": "+stage[cnt-1]);
                switch(arr[i].charAt(0)) {
                    case 'S':
                        stage[cnt-1] = (int) Math.pow(stage[cnt-1], 1);
                        break;
                    case 'D':
                        stage[cnt-1] = (int) Math.pow(stage[cnt-1], 2);
                        break;
                    case 'T':
                        stage[cnt-1] = (int) Math.pow(stage[cnt-1], 3);
                        break;
                }
            }
        }

        answer += stage[0] + stage[1] + stage[2];

        return answer;
    }

    public static void main(String[] args) {
        DartGame dg = new DartGame();
        System.out.println(dg.solution("10D#2T0S"));
    }
}
