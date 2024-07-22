package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P1238 {
    public static class Node implements Comparable<Node> {
        int to;
        int time;

        public Node(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return time - o.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int students = Integer.parseInt(inputs[0]);
        int load = Integer.parseInt(inputs[1]);
        int target = Integer.parseInt(inputs[2]);

        ArrayList<ArrayList<Node>>list = new ArrayList<>();
        ArrayList<ArrayList<Node>> reverseList = new ArrayList<>();
        int[] go = new int[students+1];
        int[] back = new int[students+1];
        Arrays.fill(go, Integer.MAX_VALUE);
        Arrays.fill(back, Integer.MAX_VALUE);

        for(int i=0; i<=students; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        int a, b, time;
        for(int i=0; i<load; i++) {
            inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);
            time = Integer.parseInt(inputs[2]);

            list.get(a).add(new Node(b, time));
            reverseList.get(b).add(new Node(a, time));
        }

        dijkstra(list, go, target);
        dijkstra(reverseList, back, target);

        int max = 0;
        for(int i=1; i<=students; i++) {
            max = Math.max(max, go[i]+back[i]);
        }
        System.out.println(max);

    }

    public static void dijkstra(ArrayList<ArrayList<Node>> list, int[] result, int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        result[start] = 0;

        Node cur;
        while(!queue.isEmpty()) {
            cur = queue.poll();
            for(Node next : list.get(cur.to)) {
                if(result[next.to] > result[cur.to] + next.time) {
                    result[next.to] = result[cur.to] + next.time;
                    queue.add(new Node(next.to, result[next.to]));
                }
            }
        }
    }
}
