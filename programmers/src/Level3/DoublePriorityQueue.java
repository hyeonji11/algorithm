package Level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    public static void main(String[] args) {
        DoublePriorityQueue dpq = new DoublePriorityQueue();
        dpq.solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});

    }
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for(int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");

            if(operation[0].equals("I")) {
                maxQueue.offer(Integer.parseInt(operation[1]));
                minQueue.offer(Integer.parseInt(operation[1]));
            } else if(!maxQueue.isEmpty()) {
                if (Integer.parseInt(operation[1]) == 1){
                    minQueue.remove(maxQueue.poll());
                } else {
                    maxQueue.remove(minQueue.poll());
                }
            }

        }

        if(!maxQueue.isEmpty()) {
            return new int[]{maxQueue.poll(), minQueue.poll()};
        }

        return answer;
    }
}
