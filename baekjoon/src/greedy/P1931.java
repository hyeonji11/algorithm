package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] meetings = new int[n][2];
        int count = 1;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, Comparator.<int[]>comparingInt(arr -> arr[1])
                .thenComparingInt(arr -> arr[0]));

        int endTime = meetings[0][1];

        for(int i=1; i<n; i++) {
            if(endTime <= meetings[i][0]) {
                count++;
                endTime = meetings[i][1];
            }
        }

        System.out.println(count);

    }
}
