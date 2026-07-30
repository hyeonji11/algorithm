package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQue = new ArrayDeque<>();
        Queue<Integer> dQue = new ArrayDeque<>();

        for(int i=0; i<senate.length(); i++) {
            if(senate.charAt(i) == 'R') {
                rQue.offer(i);
            } else {
                dQue.offer(i);
            }
        }

        while(!rQue.isEmpty() && !dQue.isEmpty()) {
            int rr = rQue.poll();
            int dd = dQue.poll();

            if(rr < dd) {
                rQue.offer(senate.length()+rr);
            } else {
                dQue.offer(senate.length()+dd);
            }

            if(rQue.size() == 0 || dQue.size() == 0) break;
        }

        if(rQue.size() == 0) return "Dire";
        return "Radiant";


    }
}
