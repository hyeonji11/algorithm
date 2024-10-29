package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15651 {
    static int n;
    static int m;

    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        arr = new int[m];

        backTracking(0);

        System.out.println(sb);
    }

    static void backTracking(int depth) {
        if(depth == m) {
            for(int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++) {
            arr[depth] = i+1;
            backTracking(depth+1);
        }
    }
}
