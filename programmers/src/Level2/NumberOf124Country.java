package Level2;

public class NumberOf124Country {
    public String solution(int n) {
        String answer = "";
        String[] arr = {"4", "1", "2"};

        while(n >0) {
            int mod = n % 3;
            for(int i=0; i<3; i++) {
                if(mod == i) {
                    answer = arr[i] + answer;
                }
            }
            n = n/3;
            if(mod == 0) n--;
        }

        return answer;
    }
    public static void main(String[] args) {
        NumberOf124Country nc = new NumberOf124Country();
        System.out.println(nc.solution(4));
    }
}
