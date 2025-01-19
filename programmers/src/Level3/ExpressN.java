package Level3;

import java.util.ArrayList;
import java.util.HashSet;

public class ExpressN {
    public int solution(int N, int number) {
        ArrayList<HashSet<Integer>> list = new ArrayList<>();

        for(int i=0; i<=8; i++) {
            list.add(new HashSet<>());
        }
        list.get(1).add(N);
        if(number == N) return 1;

        for(int i=2; i<=8; i++) {
            HashSet<Integer> set = list.get(i);
            for(int j=1; j<i; j++) {
                HashSet<Integer> a = list.get(j);
                HashSet<Integer> b = list.get(i-j);

                for(int x : a) {
                    for(int y : b) {
                        set.add(x+y);
                        set.add(x-y);
                        set.add(x*y);
                        if(x != 0 && y != 0)
                            set.add(x/y);
                    }
                }
                set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
            if(set.contains(number)) return i;
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
