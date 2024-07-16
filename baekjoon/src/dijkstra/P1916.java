package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P1916 {
    public static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost >= o.cost ? 1 : -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs;
        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[city+1];
        int[] costs = new int[city+1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i=0; i<=city; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<bus; i++) {
            inputs = br.readLine().split(" ");

            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int cost = Integer.parseInt(inputs[2]);
            list.get(a).add(new Node(b, cost));
        }

        inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);

        costs[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, costs[start]));

        Node cur;
        while(!queue.isEmpty()) {
            cur = queue.poll();
            if(!visited[cur.to]) {
                visited[cur.to] = true;
                for(Node node: list.get(cur.to)) {
                    if(costs[node.to] > costs[cur.to]+node.cost) {
                        costs[node.to] = costs[cur.to]+node.cost;
                        queue.offer(new Node(node.to, costs[node.to]));
                    }
                }
            }
        }

        System.out.println(costs[end]);
    }
}
