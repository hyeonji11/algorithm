package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};

        int num = Integer.parseInt(st.nextToken());

        boolean visited[][] = new boolean[num][num];
        int map[][] = new int[num][num];

        // 그래프 초기화
        for(int i=0; i<num; i++) {
            String str = br.readLine();
            for(int j=0; j<num; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int cnt = 0; // 단지수
        ArrayList<Integer> houseNum = new ArrayList<>();

        for(int i=0; i<num; i++) {
            for(int j=0; j<num; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    cnt++;
                    Queue<Point> queue = new LinkedList<>();
                    Point last = new Point(j, i);
                    queue.add(last);
                    visited[i][j] = true;
                    int houseCnt = 0;
                    while(!queue.isEmpty()) {
                        last = queue.poll();
                        houseCnt++;
                        for(int k=0; k<4; k++) {
                            int ny = last.y + dy[k];
                            int nx = last.x + dx[k];

                            if(nx >= 0 && ny >= 0 && nx < num && ny < num) {
                                if(!visited[ny][nx] && map[ny][nx] != 0) {
                                    queue.add(new Point(nx, ny));
                                    visited[ny][nx] = true;
                                }
                            }
                        }
                    }
                    houseNum.add(houseCnt);
                }
            }
        }

        houseNum.sort(Comparator.naturalOrder());
        System.out.println(cnt);
        for(int value : houseNum)
            System.out.println(value);

    }
}
