package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int start = 1, end = 1;
        int count = 1;
        int sum = 1;

        while(end<num) {
            if(sum < num) {
                end++;
                sum += end;
            }
            else if(sum > num) {
                sum -= start;
                start++;
            }
            else {
                count++;
                end++;
                sum += end;
            }
        }

        System.out.println(count);

    }
}
