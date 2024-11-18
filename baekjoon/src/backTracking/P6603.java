package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6603 {
    static int[] res = new int[6];
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();
        int num = -1;
        while(num != 0) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            if(num == 0) {
                break;
            }
            arr = new int[num];
            for(int i=0; i<num; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

   static public void backTracking(int depth, int start) {
        if(depth == 6) {
            for(int val : res) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<arr.length; i++) {
            res[depth] = arr[i];
            backTracking(depth+1, i+1);
        }
    }

}
