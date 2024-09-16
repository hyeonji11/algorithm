package Level2;

public class NextBigNumber {
    static public int solution(int n) {
        int oneCnt = 0;
        String binary = Integer.toBinaryString(n);
        for(int i=0; i<binary.length(); i++) {
            if(binary.charAt(i) == '1')
                oneCnt++;
        }

        int compareCnt = 0;

        while(oneCnt != compareCnt) {
            compareCnt = 0;
            String str = Integer.toBinaryString(++n);
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) == '1')
                    compareCnt++;
            }
        }

        return n;
    }
    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
    }
}
