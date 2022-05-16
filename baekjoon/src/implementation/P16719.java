package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P16719 {
    public static void zoac(String[] str, int start, int end, String[] result) {
        if(start == end) return;
        int minIdx = start;
        for(int i=start+1; i<end; i++) {
            if(str[minIdx].charAt(0) >  str[i].charAt(0)) {
                minIdx = i;
            }
        }
        result[minIdx] = str[minIdx];
        System.out.println(String.join("", result));
        zoac(str, minIdx+1, end, result);
        zoac(str, start, minIdx, result);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        String[] result = new String[str.length];
        Arrays.fill(result, "");

        zoac(str, 0, str.length, result);

    }
}
