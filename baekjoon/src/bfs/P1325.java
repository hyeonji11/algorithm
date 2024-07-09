package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P1325 {
    static int depth[];
    static boolean visited[];
    static ArrayList<Integer> list[];

    public static void bfs(int now) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);
        visited[now] = true;
        while(!queue.isEmpty()) {
            int front = queue.remove();
            for(int num: list[front]) {
                if(!visited[num]) {
                    visited[num] = true;
                    depth[num]++;
                    queue.add(num);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");

        int vertex = Integer.parseInt(inputs[0]);
        int num = Integer.parseInt(inputs[1]);
        list = new ArrayList[vertex+1];
        depth = new int[vertex+1];

        for(int i=1; i<=vertex; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<num; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            list[a].add(b);
        }

        int max =-1;

        for(int i=1; i<=vertex; i++) {
            visited = new boolean[vertex+1];
            bfs(i);
        }

        for(int i=1; i<= vertex; i++) {
            max = Math.max(max, depth[i]);
        }
        for(int i=1; i<=vertex; i++) {
            if(max == depth[i])
                sb.append(i+" ");
        }
        System.out.println(sb);
    }
}