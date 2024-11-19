package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759 {

    static int l, c;
    static char[] arr;
    static char[] res;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        res = new char[l];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        backTracking(0, 0);

        System.out.println(sb);
    }

    static public void backTracking(int depth, int start) {
        if(depth == l) {
            int vowel = 0;
            int consonant = 0;
            for(char val : res) {
                switch (val) {
                    case 'a': case 'e': case 'i': case 'o': case 'u': vowel++; break;
                    default: consonant++;
                }
            }
            if(vowel > 0 && consonant > 1)
                sb.append(String.valueOf(res)).append("\n");
            return;
        }
        for(int i=start; i<c; i++) {
            res[depth] = arr[i];
            backTracking(depth+1, i+1);
        }
    }
}
