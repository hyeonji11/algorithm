import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StandLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] order = new int[num];

        for(int i=0; i<num; i++) {
            int left = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++) {
                if(left == 0 && order[j] == 0) {
                    order[j] = i+1;
                    break;
                } else if(order[j] == 0) {
                    left--;
                }
            }
        }

        for(int i=0; i<num; i++) {
            System.out.print(order[i]+" ");
        }
    }
}
