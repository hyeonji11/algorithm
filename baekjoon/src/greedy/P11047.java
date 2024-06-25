package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] coinInfo = br.readLine().split(" ");

        int num = Integer.parseInt(coinInfo[0]);
        int total = Integer.parseInt(coinInfo[1]);
        int value[] = new int[num];
        int count = 0;

        for(int i=0; i<num; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        num -= 1;

        while(total != 0) {
            if(value[num] > total) {
                num--;
                continue;
            }
            count += total / value[num];
            total = total % value[num];
        }

        System.out.println(count);
    }
}
