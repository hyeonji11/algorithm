package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5904 {
    static String str;

    public static void moo(int num) {
        int side = 3;
        int center = 0;

        while(num > side) {
            side = center + 4 + side*2; //4는 두번째 수열
            center++;
        }

        int fb = (side-center-3) / 2;

        if(side-fb+1 <= num) {
            moo(num-side+fb);
        } else if(num == fb+1) {
            str ="m";
        } else {
            str = "o";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        moo(n);
        System.out.println(str);
    }
}
