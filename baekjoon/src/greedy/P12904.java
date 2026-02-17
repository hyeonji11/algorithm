package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12904 {
    public static void main(String[] args) throws IOException {
        // 뒤에 A를 추가한다
        // 문자열을 뒤집고 뒤에 B를 추가한다. => 문자 추가 포인터를 뒤면 앞으로, 앞이면 뒤로 바꾸고 거기에 B를 추가

        // 포인터가 앞 or 뒤 두개로 시작해야됨

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());

        int answer = 0;

        while(s.length() < t.length()) {
            if(t.charAt(t.length()-1) == 'A') {
                t.deleteCharAt(t.length()-1);
            } else {
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }

            if(s.length() == t.length() && t.toString().equals(s)) {
                answer = 1;
                break;
            }
        }

        System.out.println(answer);

    }
}
