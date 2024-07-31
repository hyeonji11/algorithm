package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int site = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<site; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        System.out.println(sb);

    }
}
