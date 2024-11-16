package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int point1 = 0, point2 = 0;
        while(point1 < n && point2 < m) {
            if(arr1[point1] < arr2[point2]) {
                sb.append(arr1[point1++]).append(" ");
            } else {
                sb.append(arr2[point2++]).append(" ");
            }
        }

        for(int i=point1; i<n; i++) {
            sb.append(arr1[i]).append(" ");
        }

        for(int i=point2; i<m; i++) {
            sb.append(arr2[i]).append(" ");
        }

        System.out.println(sb);

    }
}
