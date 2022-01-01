package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class EasyShortestDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] map = new int[height][width];
        boolean[][] visited = new boolean[height][width];
        Queue<Node> q = new LinkedList<Node>();

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for(int i=0; i<height; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    q.offer(new Node(i, j));    // 목표 지점(시작)
                    visited[i][j] = true;
                    map[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()) {
            Node node = q.poll();
            int cnt = map[node.x][node.y] + 1;

            for(int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(0 <= nx && 0 <= ny && nx < height && ny < width) {
                    if(!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        map[nx][ny] = cnt;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }

        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    map[i][j] = -1;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
