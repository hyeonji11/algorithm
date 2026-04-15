package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {
    static int[][] papers;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        papers = new int [n+1][n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(1, 1, n, n);

        System.out.println(white);
        System.out.println(blue);

    }

   static public void recursion(int startX, int startY, int endX, int endY) {
        int first = papers[startY][startX];
        for(int i=startY; i<=endY; i++) {
            for(int j=startX; j<=endX; j++) {
                if(papers[i][j] != first) {
                    first = -1;
                    break;
                }
            }
        }

        if(first == -1) {
            recursion(startX, startY, (startX+endX)/2, (startY+endY)/2);
            recursion((startX+endX)/2+1, startY, endX, (startY+endY)/2);
            recursion(startX, (startY+endY)/2+1, (startX+endX)/2, endY);
            recursion((startX+endX)/2+1, (startY+endY)/2+1, endX, endY);
        } else {
            if(first == 1) blue++;
            else white++;
        }
    }
}
