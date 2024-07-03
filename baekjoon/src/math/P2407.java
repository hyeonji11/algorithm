package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[][] D = new BigInteger[n+1][n+1];
        for(int i=0; i<=n; i++) {
            D[i][0] = BigInteger.valueOf(1);
            D[i][i] = BigInteger.valueOf(1);
            D[i][1] = BigInteger.valueOf(i);
        }

        for(int i=2; i<=n; i++) {
            for(int j=1; j<i; j++) {
                D[i][j] = D[i-1][j].add(D[i-1][j-1]);
            }
        }

        System.out.println(D[n][m]);

    }
}
