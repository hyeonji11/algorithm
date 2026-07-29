package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    Queue<Integer> queue = new LinkedList<>();
    public NumberOfRecentCalls() {

    }

    public int ping(int t) {
        queue.offer(t);

        int min = t - 3000;
        while(queue.peek() < min) {
            queue.poll();
        }

        return queue.size();
    }
}
