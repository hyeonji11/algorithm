package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717 {
    static int[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        graph = new int[node+1];
        for(int i=1; i<=node; i++) {
            graph[i] = i;
        }

        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if(value == 0) {
                union(first, second);
            } else {
                int firstRes = find(first);
                int secondRes = find(second);

                if(firstRes == secondRes) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) graph[b] = a;
        else if(a > b) graph[a] = b;
    }
    public static int find(int target) {
        if(graph[target] == target)
            return target;
        graph[target] = find(graph[target]);
        return graph[target];
    }
}
