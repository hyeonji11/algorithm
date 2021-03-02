package Level1;

public class YearOf2016 {
    public String solution(int a, int b) {
        String answer = "";
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"THU", "FRI", "SAT","SUN","MON","TUE","WED"};
        int num = 0;
        for(int i=0; i<a-1; i++) {
            num += month[i];
        }
        num += b;
        answer = day[num%7];
        return answer;
    }
    public static void main(String[] args) {
        YearOf2016 y = new YearOf2016();
        System.out.println(y.solution(1, 1));
    }
}
