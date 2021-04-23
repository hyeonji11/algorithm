package Level2;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int num = brown+yellow;

        for(int i=1; i<=num; i++) {
            if(i*i >= num && num%i==0) {
                answer[0] = i;
                answer[1] = num/answer[0];
                if((answer[0]-2) * (answer[1]-2) == yellow)
                    break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Carpet cp = new Carpet();
        int ans[] = cp.solution(8, 1);
        System.out.println(ans[0]+", "+ans[1]);
    }
}
