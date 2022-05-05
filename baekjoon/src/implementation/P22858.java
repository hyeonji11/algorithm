package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22858 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        int card = Integer.parseInt(st.nextToken());
        int shuffle = Integer.parseInt(st.nextToken());
        int[] last = new int[card];
        int[] order = new int[card];
        int[] rule = new int[card];
        int[] totalArr = new int[card];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<card; i++) {
            last[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<card; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<card; i++) {
            rule[i] = order[i]-1;
        }

        while(shuffle > 0) {
            for(int i=0; i<card; i++) {
                totalArr[rule[i]] = last[i];
            }
            last = totalArr.clone();
            shuffle--;
        }
        for(int value: totalArr) {
            System.out.print(value+" ");
        }

    }
}
