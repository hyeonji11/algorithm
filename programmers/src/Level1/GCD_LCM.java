package Level1;

public class GCD_LCM {
    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        /*
        int num = n < m ? n : m;
        for(int i=1; i<=num; i++) {
            if(n % i==0 && m%i == 0) {
                answer[0] = i;
            }
        }*/
        answer[0] = n < m ? gcd(m, n) : gcd(n, m);
        answer[1] = n * m / answer[0];

        return answer;
    }
    public static void main(String[] args) {
        GCD_LCM gl = new GCD_LCM();
        int[] result = gl.solution(2, 5);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
