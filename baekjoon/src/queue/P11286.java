package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class P11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue();
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>(Collections.reverseOrder());

        int num = Integer.parseInt(br.readLine());
        int val = 0;
        for(int i=0; i<num; i++) {
            val = Integer.parseInt(br.readLine());
            if(val == 0) {
                if(queue.isEmpty() && negativeQueue.isEmpty())
                    System.out.println("0");
                else if(queue.isEmpty())
                    System.out.println(negativeQueue.poll());
                else if(negativeQueue.isEmpty())
                    System.out.println(queue.poll());
                else {
                    if(queue.peek() >= Math.abs(negativeQueue.peek()))
                        System.out.println(negativeQueue.poll());
                    else
                        System.out.println(queue.poll());
                }
            } else if(val < 0)
                negativeQueue.add(val);
            else
                queue.add(val);

        }
    }
}
