package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int D[][] = new int[row+width][row+width];

        for(int i=1; i<D.length; i++) {
            D[i][1] = 1;
            D[i][i] = 1;
        }

        for(int i=3; i<D.length; i++) {
            for(int j=2; j<i; j++) {
                D[i][j] = D[i-1][j-1] + D[i-1][j];
            }
        }

        int sum = 0;
        int num = 1;
        for(int i=row; i<row+width; i++) {
            for(int j=col; j<col+num; j++) {
                sum += D[i][j];
            }
            num++;
        }
        System.out.println(sum);
    }
}
