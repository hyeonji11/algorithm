package bfs;

import java.io.*;
import java.util.*;

public class FindTreeParent {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int vertex = Integer.parseInt(br.readLine());
        int[] parent = new int[vertex+1];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list[] = new ArrayList[vertex+1];
        int v1, v2;

        for(int i=1; i<=vertex; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<vertex-1; i++) {
            st = new StringTokenizer(br.readLine());
            //String str[] = br.readLine().split(" ");
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        q.offer(1);
        while(!q.isEmpty()) {
            int key = q.poll();
            for(int num: list[key]) {
                if(parent[num] != 0) continue;
                parent[num] = key;
                q.offer(num);
            }
        }

        for(int i=2; i<parent.length; i++) {
            bw.write(parent[i]+"\n");
        }
        bw.close();
    }
}
