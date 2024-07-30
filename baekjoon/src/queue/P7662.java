package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++) {
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            int num = Integer.parseInt(br.readLine());

            for(int j=0; j<num; j++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if(str.equals("I")) {
                    tm.put(value, tm.getOrDefault(value, 0)+1);
                } else {
                    if(tm.isEmpty())
                        continue;
                    int key;
                    if(value == 1) {
                        key = tm.lastKey();
                    } else {
                        key = tm.firstKey();
                    }
                    int cnt = tm.get(key);
                    if(cnt == 1)
                        tm.remove(key);
                    else
                        tm.put(key, cnt-1);
                }
            }

            if(tm.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(tm.lastKey()+" "+tm.firstKey());
            }
        }
    }
}
