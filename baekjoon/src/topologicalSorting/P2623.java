package topologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int num = Integer.parseInt(inputs[0]);
        int pd = Integer.parseInt(inputs[1]);

        int[] indegree = new int[num+1];
        ArrayList<Integer>[] list = new ArrayList[num+1];

        for(int i=1; i<=num; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<pd; i++) {
            inputs = br.readLine().split(" ");
            int order = Integer.parseInt(inputs[0]);
            int prev = Integer.parseInt(inputs[1]);
            int cur;
            for(int j=2; j<=order; j++) {
                cur = Integer.parseInt(inputs[j]);
                indegree[cur]++;
                list[prev].add(cur);
                prev = cur;
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=num; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
                cnt++;
            }
        }

        int now;
        while(!queue.isEmpty()) {
            now = queue.poll();
            sb.append(now).append("\n");
            for(int value : list[now]) {
                indegree[value]--;
                if(indegree[value] == 0) {
                    queue.add(value);
                    cnt++;
                }
            }
        }

        if(cnt == num)
            System.out.println(sb);
        else
            System.out.println("0");

    }
}
