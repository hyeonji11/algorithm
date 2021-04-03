package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class OrganicCabbage {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> list;
    static int count = 0;

    static void bfs(int[][] area) {
        if(list.isEmpty()) return;
        while(!list.isEmpty()) {
            int[] arr = list.poll();
            if(area[arr[1]][arr[0]] == 1) {
                area[arr[1]][arr[0]] = 0;
                int nx = 0;
                int ny = 0;
                for(int d=0; d<4; d++) {
                    nx = arr[0]+dx[d];
                    ny = arr[1]+dy[d];
                    if(nx<0 || ny<0 || nx>=area[arr[1]].length || ny>=area.length) continue;
                    if(area[ny][nx] == 1) {
                        list.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        count++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        for(int i=0; i<testcase; i++) { //테스트 케이스 수만큼
            String[] info = br.readLine().split(" ");
            int[][] area = new int[Integer.parseInt(info[1])][Integer.parseInt(info[0])];
            int num = Integer.parseInt(info[2]);
            int[][] loc = new int[num][2];
            list = new LinkedList<>();

            for(int j=0; j<num; j++) {
                String[] point = br.readLine().split(" ");
                area[Integer.parseInt(point[1])][Integer.parseInt(point[0])] = 1;
                loc[j][0] = Integer.parseInt(point[0]);
                loc[j][1] = Integer.parseInt(point[1]);
            }

            for(int j=0; j<num; j++) {
                if(area[loc[j][1]][loc[j][0]] != 1) continue;
                list.offer(new int[] {loc[j][0], loc[j][1]});
                bfs(area);
            }
            System.out.println(count);
            count = 0;
        }
    }
}
