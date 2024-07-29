package minimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P16398 {
    public static class Edge {
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int planet = Integer.parseInt(br.readLine());

        int[][] graph = new int[planet][planet];
        arr = new int[planet];
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        int sum = 0;
        int cnt = planet;

        for(int i=0; i<planet; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<planet; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
            arr[i] = i;
            for(int j=i+1; j<planet; j++) {
                queue.offer(new Edge(i, j, graph[i][j]));
            }
        }

        Edge cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            if(find(cur.a) != find(cur.b)) {
                union(cur.a, cur.b);
                sum += cur.cost;
                if(--cnt == 1)
                    break;
            }
        }

        System.out.println(sum);
    }

    public static int find(int target) {
        if(arr[target] == target) return target;
        return arr[target] = find(arr[target]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b)
            arr[b] = a;
        else
            arr[a] = b;
    }
}
