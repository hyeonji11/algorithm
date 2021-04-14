package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EfficientHacking {
    static int depth[];
    static boolean visited[];
    static ArrayList<Integer> list[];

    public static void dfs(int start) {
        visited[start] = true;
        for(int num: list[start]) {
            if(!visited[num]) {
                depth[num]++;
                dfs(num);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int vertex = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        list = new ArrayList[vertex+1];
        depth = new int[vertex+1];

        for(int i=1; i<=vertex; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        int max =-1;

        for(int i=1; i<=vertex; i++) {
            visited = new boolean[vertex+1];
            dfs(i);
        }

        for(int i=1; i<= vertex; i++) {
            if(max < depth[i]) {
                max = depth[i];
            }
        }
        for(int i=1; i<=vertex; i++) {
            if(max == depth[i])
                sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
}