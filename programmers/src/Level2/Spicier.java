package Level2;

import java.util.PriorityQueue;

public class Spicier {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int value : scoville) {
            pq.add(value);
        }

        while(pq.peek() <= K && pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int newNum = num1 + num2*2;
            pq.add(newNum);
            answer++;
        }

        if(pq.peek() < K) answer = -1;

        return answer;
    }
    public static void main(String[] args) {
        Spicier s = new Spicier();
        System.out.println(s.solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
    }
}
