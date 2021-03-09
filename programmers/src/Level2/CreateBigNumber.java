package Level2;

public class CreateBigNumber {
    public String solution(String number, int k) {
        //String answer = "";
        StringBuilder sb = new StringBuilder();

        int numLen = number.length() - k;
        int sIdx = 0;
        int fIdx = k;

        String[] arr = number.split("");
        int[] num = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        //answer.length() <numLen
        while(k>0 && sb.length() < numLen) {
            int max = -1;
            int maxIdx = -1;
            for(int i=sIdx; i<=fIdx; i++) {
                if(max<num[i]) {
                    max = num[i];
                    maxIdx = i;
                }
            }
            k = k-(maxIdx - sIdx);
            sIdx = maxIdx+1;
            fIdx++;
            sb.append(arr[maxIdx]);
            //answer += arr[maxIdx];
        }
        //answer.length() != numLen
        if(sb.length() != numLen) {
            sb.append(number.substring(sIdx));
            //answer += number.substring(sIdx);
        }
        //return answer;
        return sb.toString();
    }
    public static void main(String[] args) {
        CreateBigNumber c = new CreateBigNumber();
        System.out.println(c.solution("0000", 2));
    }
}
