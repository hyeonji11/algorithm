package Level3;

import java.util.Arrays;

public class Immigration {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long s = 0;
        long f = (long)times[times.length-1]*(long)n;
        long answer = f;
        while(s<=f) {
            long mid = (s+f)/2;
            long pNum = 0;
            for(int i=0; i<times.length; i++) {
                pNum += mid/times[i];
            }
            if(pNum >= n) {
                f = mid-1;
                answer = Math.min(answer, mid);
            } else {
                s = mid+1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Immigration im = new Immigration();
        System.out.println(im.solution(10, new int[] {1, 5}));
    }
}
