package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11724 {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        int count = 0;

        // 인접리스트 초기화
        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            setGraph(first, second);
            setGraph(second, first);
        }
        visited = new boolean[node+1]; //default false

        for(int i=1; i<visited.length; i++) {
            if(!visited[i]) {
                count++;
                visitNode(i);
            }
        }

        System.out.println(count);

    }
    static void visitNode(int currentNode) {
        if(visited[currentNode])
            return;
        visited[currentNode] = true;
        if(!graph.containsKey(currentNode))
            return;
        List<Integer> list = graph.get(currentNode);
        for(int i=0; i<list.size(); i++) {
            if(!visited[list.get(i)])
                visitNode(list.get(i));
        }
    }
    static void setGraph(int firstNode, int secondNode) {
        if(graph.containsKey(firstNode)) {
            List<Integer> list = graph.get(firstNode);
            list.add(secondNode);
            graph.put(firstNode, list);
        } else {
            graph.put(firstNode, new ArrayList<>(Arrays.asList(secondNode)));
        }
    }
}
