import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5904 {
    public void moo() {
        // S(k) = S(k-1) + m + o*(k+2) + S(k-1)
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // repeat 사용방법
        String o = "o";
        System.out.println("repeat : "+o.repeat(3)); // 위의 o*(k+2)를 이걸로

        StringBuilder sb = new StringBuilder("");

    }
}
