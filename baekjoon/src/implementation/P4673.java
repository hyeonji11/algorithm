package implementation;

import java.util.Arrays;

public class P4673 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        boolean[] self = new boolean[10001];
        Arrays.fill(self, true);


        for(int i=1; i<=10000; i++) {
            int sum = i;
            int num = i;
            while(num != 0) {
                sum += num % 10;
                num /= 10;
            }
            if(sum > 10000) continue;
            self[sum] = false;
        }

        for(int i=1; i<=10000; i++) {
            if(self[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);

    }
}
