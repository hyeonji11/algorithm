package Level2;

import java.util.Arrays;

public class MaxAndMin {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] arr = s.split(" ");
        int[] numArr = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(numArr);

        min = numArr[0];
        max = numArr[numArr.length-1];
        answer = min+" "+max;
        return answer;
    }
    public static void main(String[] args) {
        MaxAndMin mam = new MaxAndMin();
        System.out.println(mam.solution("1 3 2 4"));
    }
}
