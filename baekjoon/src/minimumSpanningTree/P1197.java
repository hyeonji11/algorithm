package minimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P1197 {
    public static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int node = Integer.parseInt(inputs[0]);
        int edge = Integer.parseInt(inputs[1]);

        ArrayList<Edge> graph = new ArrayList<>();
        arr = new int[node+1];

        for(int i=1; i<=node; i++) {
            arr[i] = i;
        }

        int a, b, w;
        for(int i=0; i<edge; i++) {
            inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);
            w = Integer.parseInt(inputs[2]);

            graph.add(new Edge(a, b, w));
        }

        Collections.sort(graph, Comparator.comparingInt(o -> o.weight));
        int res = 0;
        int cnt = 0;

        Edge cur;
        for(int i=0; i<edge; i++) {
            cur = graph.get(i);

            if(find(cur.start) != find(cur.end)) {
                union(cur.start, cur.end);
                res += cur.weight;
                cnt++;
                if(cnt == node-1)
                    break;
            }
        }

        System.out.println(res);
    }

    public static int find(int target) {
        if(arr[target] == target)
            return target;
        return arr[target] = find(arr[target]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }
}
