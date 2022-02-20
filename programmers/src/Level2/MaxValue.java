package Level2;

import java.util.Arrays;
import java.util.Comparator;

public class MaxValue {
    public String solution(int[] numbers) {
        String answer = "";
        String strArr[] = new String[numbers.length];
        for(int i=0; i< numbers.length; i++) {
            strArr[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int n1 = Integer.parseInt(o1+o2);
                int n2 = Integer.parseInt(o2+o1);
                if(n1 > n2) {
                    return -1;
                } else if(n2 > n1) {
                    return 1;
                }
                return 0;
            }
        });
        if(strArr[0].equals("0")) {
            return "0";
        }
        answer = String.join("", strArr);
        return answer;
    }
    public static void main(String[] args) {
        MaxValue mv = new MaxValue();
        System.out.println(mv.solution(new int[] {113, 11, 13, 3}));
    }
}