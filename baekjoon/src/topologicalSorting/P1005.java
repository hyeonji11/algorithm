package topologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String[] inputs;

        for(int i=0; i<testCase; i++) {
            inputs = br.readLine().split(" ");
            int num = Integer.parseInt(inputs[0]);
            int rule = Integer.parseInt(inputs[1]);

            int[] time = new int[num+1];
            int[] indegree = new int[num+1];
            ArrayList<Integer>[] list = new ArrayList[num+1];
            Queue<Integer> queue = new LinkedList<>();
            int[] result = new int[num+1];

            inputs = br.readLine().split(" ");
            for(int j=0; j<inputs.length; j++) {
                time[j+1] = Integer.parseInt(inputs[j]);
            }

            for(int j=1; j<=num; j++) {
                list[j] = new ArrayList<>();
            }

            for(int j=1; j<=rule; j++) {
                inputs = br.readLine().split(" ");

                int a = Integer.parseInt(inputs[0]);
                int b = Integer.parseInt(inputs[1]);

                list[a].add(b);
                indegree[b]++;
            }

            for(int j=1; j<=num; j++) {
                if(indegree[j] == 0)
                    queue.add(j);
            }

            int cur;
            while(!queue.isEmpty()) {
                cur = queue.poll();
                for(int next: list[cur]) {
                    indegree[next]--;
                    result[next] = Math.max(result[next], result[cur] + time[cur]);
                    if(indegree[next] == 0)
                        queue.add(next);
                }
            }

            int target = Integer.parseInt(br.readLine());
            System.out.println(result[target]+time[target]);

        }
    }
}
