package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder("");

        TreeMap<String, Integer> tm = new TreeMap<>();
        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            sb.append(st.nextToken());
            if(tm.containsKey(sb.toString())) {
                tm.put(sb.toString(), tm.get(sb.toString())+1);
            } else {
                tm.put(sb.toString(), 1);
            }
            sb.setLength(0);
        }

        for(String str: tm.keySet()) {
            System.out.println(str+" "+tm.get(str));
        }
    }
}
