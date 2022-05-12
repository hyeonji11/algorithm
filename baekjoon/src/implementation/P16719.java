package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class P16719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Integer, Integer> map = new TreeMap<>();
        String[] strArr = new String[str.length()];
        StringBuilder sb;

        for(int i=0; i<str.length(); i++) {
            map.put((int)str.charAt(i), i);
        }

        for(Integer val : map.keySet()) {
            sb = new StringBuilder("");
            int idx = map.get(val);
            strArr[idx] = str.substring(idx, idx+1);
            for(String string: strArr) {
                if(string != null)
                    sb.append(string);
            }

            System.out.println(sb.toString());
        }
    }
}
