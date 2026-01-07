package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortCut {
    public static void main(String[] args) {

    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while(!queue.isEmpty()){
            Point point = queue.poll();
            visited[point.y][point.x] = true;

            for(int i=0; i<4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx >= 0 && nx < maps[0].length && ny >= 0 && ny < maps.length && !visited[ny][nx]){
                    if(maps[ny][nx] == 1) {
                        maps[ny][nx] = maps[point.y][point.x] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }

        if(maps[maps.length-1][maps[0].length -1] == 1)
            return -1;
        return maps[maps.length-1][maps[0].length -1];
    }
}
