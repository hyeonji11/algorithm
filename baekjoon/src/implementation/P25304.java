package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int total = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int sum = 0;

        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());

            sum += cost*amount;
        }

        if(total == sum)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
