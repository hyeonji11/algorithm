package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int sum = 0;

        String[] arr = br.readLine().split("");

        for(int i=0; i<len; i++) {
            sum += Integer.parseInt(arr[i]);
        }

        System.out.println(sum);
    }
}
