package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        int[][] max = new int[num+1][3];
        int[][] min = new int[num+1][3];

        for(int i=1; i<=num; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + arr[0];
            max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + arr[1];
            max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + arr[2];

            min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + arr[0];
            min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + arr[1];
            min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + arr[2];
        }

        System.out.println(Math.max(Math.max(max[num][0], max[num][1]), max[num][2])+" "+Math.min(Math.min(min[num][0], min[num][1]), min[num][2]));

    }
}
