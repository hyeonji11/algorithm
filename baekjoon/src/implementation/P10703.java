package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        char[][] picture = new char[row][col];
        int min = 3000;
        int[] meteor = new int[col];
        Arrays.fill(meteor, -1);
        int[] groundIndex = new int[col];

        for(int i=0; i<row; i++) {
            picture[i] = br.readLine().toCharArray();
        }

        int interval;

        for(int i=0; i<col; i++) {
            groundIndex[i] = row-1;
            for(int j=row-2; j>=0; j--) {
                if(picture[j][i] == 'X') {
                    interval = groundIndex[i]-j-1;
                    min = Math.min(interval, min);
                    meteor[i] = j;
                    break;
                } else if(picture[j][i] == '#') {
                    groundIndex[i] = j;
                }
            }
        }

        for(int i=0; i<col; i++) {
            if(meteor[i] == -1)
                continue;
            for(int j=groundIndex[i]-1; j>=0; j--) {
                if(picture[j][i] == 'X') {
                    picture[j+min][i] = 'X';
                    picture[j][i] = '.';
                }
            }
        }

        for(int i=0; i<row; i++) {
            System.out.println(new String(picture[i]));
        }

    }
}
