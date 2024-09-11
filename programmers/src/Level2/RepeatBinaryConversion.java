package Level2;

public class RepeatBinaryConversion {
    static public int[] solution(String s) {
        int[] answer = new int[2];

        int convertCnt = 0;
        int zeroCnt = 0;

        while(!s.equals("1")) {
            int len = s.length();
            int zero = 0;
            for(int i=0; i<len; i++) {
                if(s.charAt(i) == '0') {
                    zero++;
                }
            }
            zeroCnt += zero;

            s = Integer.toBinaryString(len-zero);
            convertCnt++;
        }

        answer[0] = convertCnt;
        answer[1] = zeroCnt;

        return answer;
    }

    public static void main(String[] args) {
        int[] res = solution("1111111");

        System.out.println(res[0]+" "+res[1]);
    }
}
