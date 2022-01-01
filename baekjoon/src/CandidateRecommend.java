import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CandidateRecommend {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int photoNum = Integer.parseInt(br.readLine());
        int totalRec = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] photo = new int[photoNum];
        int[] student = new int[101];

        while(st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            student[value]++;

        }


    }

}
