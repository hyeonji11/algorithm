package minimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P1922 {
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

        int computer = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        arr = new int[computer+1];
        ArrayList<Edge> list = new ArrayList<>();

        for(int i=1; i<=computer; i++) {
            arr[i] = i;
        }

        String[] inputs;
        for(int i=0; i<line; i++) {
            inputs = br.readLine().split(" ");

            list.add(new Edge(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2])));
        }

        Collections.sort(list, Comparator.comparingInt(o -> o.cost));

        int res = 0;
        for(int i=0; i<line; i++) {
            Edge edge = list.get(i);

            if(find(edge.a) != find(edge.b)) {
                union(edge.a, edge.b);
                res += edge.cost;
            }
        }

        System.out.println(res);

    }

    public static int find (int target) {
        if(arr[target] == target) return target;
        return arr[target] = find(arr[target]);
    }

    public static void union (int a, int b) {
        a = find(a);
        b = find(b);

        arr[b] = a;
    }
}
