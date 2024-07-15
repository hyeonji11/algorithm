package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1753 {
    public static class Node {
        private int to;
        private int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int node = Integer.parseInt(inputs[0]);
        int edge = Integer.parseInt(inputs[1]);
        int start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        int[] distance = new int[node+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        boolean[] visited = new boolean[node+1];

        for(int i=0; i<=node; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<edge; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int w = Integer.parseInt(inputs[2]);

            list.get(a).add(new Node(b, w));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int cur;
        while(!queue.isEmpty()) {
            cur = queue.poll();
            visited[cur] = true;
            for(Node next: list.get(cur)) {
                distance[next.to] = Math.min(distance[next.to], distance[cur]+next.weight);
            }
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            for(int i=1; i<distance.length; i++) {
                if(min > distance[i] && !visited[i]) {
                    min = distance[i];
                    minIndex = i;
                }
            }
            if(minIndex != 0)
                queue.add(minIndex);
        }

        for(int i=1; i<distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(distance[i]);
        }

    }
}
