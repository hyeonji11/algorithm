package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(xList.contains(x)) {
                int index = xList.indexOf(x);
                xList.remove(index);
            } else {
                xList.add(x);
            }

            if(yList.contains(y)) {
                int index = yList.indexOf(y);
                yList.remove(index);
            } else {
                yList.add(y);
            }
        }

        System.out.println(xList.get(0)+" "+yList.get(0));


    }
}
