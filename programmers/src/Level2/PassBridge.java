package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class PassBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        int curWeight = 0;
        int idx = 0;
        Queue<Integer> bridge_time = new LinkedList<>();
        Queue<Integer> bridge_truck = new LinkedList<>();

        while(true) {
            if(!bridge_time.isEmpty() && time-bridge_time.peek() == bridge_length) {
                bridge_time.poll();
                int removeWeight = bridge_truck.poll();
                curWeight -= removeWeight;
            }
            if(idx<truck_weights.length && truck_weights[idx]+curWeight <= weight) {
                curWeight += truck_weights[idx];
                bridge_time.add(time);
                bridge_truck.add(truck_weights[idx]);
                idx++;
            }
            if(bridge_time.isEmpty()) break;
            time++;
        }

        return time;
    }
    public static void main(String[] args) {
        PassBridge pb = new PassBridge();
        System.out.println(pb.solution(2, 10, new int[] {7, 4, 5, 6}));
    }
}
