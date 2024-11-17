package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(st.nextToken());
            int col1 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int j=row1; j<=row2; j++) {
                sum += arr[j][col2] - arr[j][col1-1];
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
