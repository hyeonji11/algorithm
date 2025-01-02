package practice;

public class BinaryGap {
    public int solution(int N) {
        int answer = 0;

        String binary = Integer.toBinaryString(N);
        System.out.println("binary : "+binary);

        int gap = 0;

        for(int i=0; i<binary.length(); i++) {
            if(binary.charAt(i) == '0') {
                gap++;
            } else {
                answer = Math.max(answer, gap);
                gap = 0;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        System.out.println(bg.solution(32));
    }
}
