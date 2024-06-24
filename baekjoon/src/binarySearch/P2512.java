package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityNum = Integer.parseInt(st.nextToken());
        int budget[] = new int[cityNum];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cityNum; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int totalBudget = Integer.parseInt(st.nextToken());

        Arrays.sort(budget);

        int start = 0;
        int end = budget[cityNum-1];
        int res = 0;

        while(start <= end) {
            int mid = (start+end)/2;
            int sum = 0;
            for(int i=0; i<cityNum; i++) {
                if(budget[i] >= mid) {
                    sum += mid;
                } else {
                    sum += budget[i];
                }
            }
            if(sum > totalBudget) {
                end = mid - 1;
            } else {
                start = mid + 1;
                res = Math.max(mid, res);
            }
        }
        System.out.println(res);
    }
}
