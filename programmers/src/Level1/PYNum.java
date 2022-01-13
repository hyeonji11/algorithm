package Level1;

public class PYNum {
    boolean solution(String s) {
        boolean answer = true;
        int pNum = 0;
        int yNum = 0;

        s = s.toLowerCase();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'p') {
                pNum++;
            } else if(s.charAt(i) == 'y') {
                yNum++;
            }
        }

        if(pNum != yNum) answer = false;

        return answer;
    }
    public static void main(String[] args) {
        PYNum py = new PYNum();
        System.out.println(py.solution("PpsssYY"));
    }
}
