package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1504 {
    public static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int node;
    static ArrayList<ArrayList<Node>> list;
    static final int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        node = Integer.parseInt(inputs[0]);
        int edge = Integer.parseInt(inputs[1]);

        int[] res = new int[node+1];
        Arrays.fill(res, INF);

        list = new ArrayList<>();

        for(int i=0; i<=node; i++) {
            list.add(new ArrayList<>());
        }

        int a, b, weight;
        for(int i=0; i<edge; i++) {
            inputs = br.readLine().split(" ");

            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);
            weight = Integer.parseInt(inputs[2]);

            list.get(a).add(new Node(b, weight));
            list.get(b).add(new Node(a, weight));
        }

        inputs = br.readLine().split(" ");
        int v1 = Integer.parseInt(inputs[0]);
        int v2 = Integer.parseInt(inputs[1]);

        int path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, node);
        int path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, node);

        if(path1 >= INF && path2 >= INF)
            System.out.println("-1");
        else {
            System.out.println(Math.min(path1, path2));
        }


    }

    public static int dijkstra(int start, int end) {
        int[] res = new int[node+1];
        Arrays.fill(res, INF);
        res[start] = 0;

        boolean[] visited = new boolean[node+1];


        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        queue.add(new Node(start, 0));

        Node cur;
        while(!queue.isEmpty()) {
            cur = queue.poll();

            if(visited[cur.to]) continue;
            visited[cur.to] = true;

            for(Node next : list.get(cur.to)) {
                if(res[next.to] > res[cur.to] + next.weight) {
                    res[next.to] = res[cur.to] + next.weight;
                    queue.add(new Node(next.to, res[next.to]));
                }
            }
        }

        return res[end];
    }
}
