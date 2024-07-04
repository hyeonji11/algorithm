package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1707 {
    static ArrayList<Integer>[] list;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());

        for(int i=0; i<tc; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            list = new ArrayList[node+1];
            visited = new boolean[node+1];
            check = new int[node+1];
            isEven = true;

            for(int j=1; j<=node; j++) {
                list[j] = new ArrayList<>();
            }

            for(int j=0; j<edge; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[start].add(end);
                list[end].add(start);
            }

            for(int j=1; j<=node; j++) {
                if(isEven)
                    dfs(j);
                else
                    break;
            }
            if(isEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public static void dfs(int node) {
        visited[node] = true;
        for(int value : list[node]) {
            if(!visited[value]) {
                check[value] = (check[node] + 1) % 2;
                dfs(value);
            } else if(check[node] == check[value]){
                isEven = false;
            }
        }
    }
}
