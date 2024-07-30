package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P10026 {

    static boolean[][] visited;
    static char[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputs;

        int num = Integer.parseInt(br.readLine());
        visited = new boolean[num][num];
        graph = new char[num][num];

        for(int i=0; i<num; i++) {
            inputs = br.readLine();
            for(int j=0; j<num; j++) {
                graph[i][j] = inputs.charAt(j);
            }
        }

        Queue<Point> queue = new LinkedList<>();
        int cnt = 0;
        for(int i=0; i<num; i++) {
            for(int j=0; j<num; j++) {
                if(!visited[i][j]) {
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                    bfs(graph[i][j], queue);
                    cnt++;
                }
            }
        }
        System.out.print(cnt+" ");

        for(int i=0; i<num; i++) {
            for(int j=0; j<num; j++) {
                visited[i][j] = false;
                if(graph[i][j] == 'G')
                    graph[i][j] = 'R';
            }
        }
        cnt = 0;

        for(int i=0; i<num; i++) {
            for(int j=0; j<num; j++) {
                if(!visited[i][j]) {
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                    bfs(graph[i][j], queue);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);


    }

    public static void bfs(char value, Queue<Point> queue) {
        int nx, ny;
        Point cur;
        while(!queue.isEmpty()) {
            cur = queue.poll();
            for(int i=0; i<4; i++) {
                nx = cur.col + dx[i];
                ny = cur.row + dy[i];
                if(nx >= 0 && ny >= 0 && nx < graph.length && ny < graph.length) {
                    if(!visited[ny][nx] && graph[ny][nx] == value) {
                        queue.offer(new Point(ny, nx));
                        visited[ny][nx] = true;
                    }

                }
            }
        }
    }
}
