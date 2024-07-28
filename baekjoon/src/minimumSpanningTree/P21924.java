package minimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P21924 {
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

        String[] inputs = br.readLine().split(" ");
        int city = Integer.parseInt(inputs[0]);
        int load = Integer.parseInt(inputs[1]);

        arr = new int[city+1];
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        long total = 0;
        long sum = 0;
        int cost;
        int cnt = city;

        for(int i=1; i<=city; i++) {
            arr[i] = i;
        }

        for(int i=0; i<load; i++) {
            inputs = br.readLine().split(" ");
            cost = Integer.parseInt(inputs[2]);

            queue.offer(new Edge(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), cost));

            total += cost;
        }

        Edge cur;
        while(!queue.isEmpty()) {
            cur = queue.poll();

            if(find(cur.a) != find(cur.b)) {
                union(cur.a, cur.b);
                sum += cur.cost;
                cnt--;
                if(cnt == 1)
                    break;
            }
        }

        boolean isConnect = true;
        int num = find(arr[1]);
        for(int i=2; i<=city; i++) {
            if(find(arr[i]) != num) {
                isConnect = false;
                break;
            }
        }
        if(isConnect)
            System.out.println(total-sum);
        else
            System.out.println("-1");

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
