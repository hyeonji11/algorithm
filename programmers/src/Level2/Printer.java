package Level2;

import java.util.*;

public class Printer {
    int order;
    boolean check = false;

    public int solution(int[] priorities, int location) {
        int idx = 0;

        ArrayList<Printer> queue = new ArrayList<>();
        int point[] = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int count[] = new int[priorities.length];

        for(int i=0; i<priorities.length; i++) {
            Printer p = new Printer();
            if(i==location) {
                p.check = true;
            }
            p.order = point[priorities[i]];
            count[i] = p.order;
            queue.add(p);
        }

        Arrays.sort(count);

        while(queue.size()>0) {
            Printer p = queue.get(0);
            queue.remove(0);
            if(count[idx] == p.order) {
                idx++;
                if(p.check) break;
            } else {
                queue.add(p);
            }
        }

        return idx;
    }
    public static void main(String[] args) {
        Printer printer = new Printer();
        System.out.println(printer.solution(new int[] {2, 1, 3, 2}, 2));
    }
}
