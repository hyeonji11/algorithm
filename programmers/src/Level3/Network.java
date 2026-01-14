package Level3;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            queue.add(i);
            answer++;
            
            while(!queue.isEmpty()) {
                int current = queue.poll();
                visited[current] = true;
                int[] connections = computers[current];
                for(int j = 0; j < connections.length; j++) {
                    if(connections[j] == 1 && !visited[j]) {
                        queue.add(j);
                    }
                }
            }
        }
        return answer;
    }


}
