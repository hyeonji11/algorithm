package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int[][] arr = new int[num][3];

        st = new StringTokenizer(br.readLine());
        for(int j=0; j<3; j++) {
            arr[0][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<num; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Math.min(arr[i-1][1], arr[i-1][2]) + Integer.parseInt(st.nextToken());
            arr[i][1] = Math.min(arr[i-1][0], arr[i-1][2]) + Integer.parseInt(st.nextToken());
            arr[i][2] = Math.min(arr[i-1][0], arr[i-1][1]) + Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<3; i++) {
            min = Math.min(arr[num-1][i], min);
        }
        System.out.println(min);
    }
}
