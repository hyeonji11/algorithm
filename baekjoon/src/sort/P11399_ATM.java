package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] time = new int[num];

        String[] arr = br.readLine().split(" ");

        for(int i=0; i<num; i++) {
            time[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(time);

        int sum=time[0];

        for(int i=1; i<num; i++) {
            time[i] = time[i-1] + time[i];
            sum += time[i];
        }

        System.out.println(sum);
    }
}
