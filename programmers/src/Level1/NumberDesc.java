package Level1;

import java.util.Arrays;

public class NumberDesc {
    public long solution(long n) {
        long answer = 0;
        String str = ""+n;
        String res = "";
        int[] arr = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        for(int i=str.length()-1; i >= 0; i--) {
            res += arr[i];
        }

        answer = Long.parseLong(res);

        return answer;
    }
    public static void main(String[] args) {
        NumberDesc nd = new NumberDesc();
        System.out.println(nd.solution(118372));
    }
}
