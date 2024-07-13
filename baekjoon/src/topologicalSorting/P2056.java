package topologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[num+1];
        int[] indegree = new int[num+1];
        int[] time = new int[num+1];
        String[] inputs;
        int cnt;
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[num+1];

        for(int i=1; i<=num; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=num; i++) {
            inputs = br.readLine().split(" ");
            time[i] = Integer.parseInt(inputs[0]);

            cnt = Integer.parseInt(inputs[1]);
            if(cnt == 0)
                continue;

            int value;
            for(int j=2; j<cnt+2; j++) {
                value = Integer.parseInt(inputs[j]);

                list[value].add(i);
                indegree[i]++;
            }
        }

        for(int i=1; i<=num; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        int cur;
        while(!queue.isEmpty()) {
            cur = queue.poll();

            for(int next: list[cur]) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[cur]+time[cur]);

                if(indegree[next] == 0)
                    queue.add(next);
            }
        }

        int max = 0;
        for(int i=1; i<=num; i++) {
            max = Math.max(max, result[i]+time[i]);
        }

        System.out.println(max);
    }
}
