package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int maze[][] = new int[row][col];

        int nx, ny, cx, cy;
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        //String[] arr;
        for(int i=0; i < row; i++) {
            String str = br.readLine();
            //arr = br.readLine().split("");
            for(int j=0; j<col; j++) {
                //maze[i][j] = Integer.parseInt(arr[j]);
                maze[i][j] = str.charAt(j) - '0';
            }
        }
        xq.offer(0);
        yq.offer(0);
        while(!xq.isEmpty()) {
            cx = xq.poll();
            cy = yq.poll();

            for(int i=0; i<4; i++) {
                nx = cx+dx[i];
                ny = cy+dy[i];
                if(nx < 0 || ny < 0 || nx >= col || ny >= row)
                    continue;
                if(maze[ny][nx] == 0) continue;
                else if(maze[ny][nx]==1) {
                    xq.offer(nx);
                    yq.offer(ny);
                    maze[ny][nx] += maze[cy][cx];
                }
            }
        }
        System.out.println(maze[row-1][col-1]);
    }
}
