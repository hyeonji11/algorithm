package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11050 {
    static int n, r;
    static int D[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // 배열 선언
        D = new int[n+1][n+1];

        // 배열 초기화
        for(int i=0; i<=n; i++) {
            D[i][1] = i; // i개에서 1개 선택하는 경우의 수는 i개
            D[i][0] = 1; // i개에서 0개 선택하는 경우의 수는 1개
            D[i][i] = 1; // i개에서 i개 선택하는 경우의 수는 1개
        }

        // 점화식으로 배열 완성
        for(int i=2; i<=n; i++) {
            for(int j=1; j<i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }

        System.out.println(D[n][r]);

    }
}
