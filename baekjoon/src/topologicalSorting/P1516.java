package topologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] access = new int[num+1]; // 진입차수
        int[] time = new int[num+1];
        int[] result = new int[num+1];
        ArrayList<Integer>[] list = new ArrayList[num+1];
        String[] inputs;
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=num; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=num; i++) {
            inputs = br.readLine().split(" ");
            time[i] = Integer.parseInt(inputs[0]);
            for(int j=1; j<inputs.length-1; j++) {
                int value = Integer.parseInt(inputs[j]);
                list[value].add(i);
                access[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=num; i++) {
            if(access[i] == 0)
                queue.add(i);
        }

        int cur;
        while(!queue.isEmpty()) {
            cur = queue.poll();
            for(int val : list[cur]) {
                access[val]--;
                result[val] = Math.max(result[val], result[cur]+time[cur]);
                if(access[val] == 0)
                    queue.add(val);

            }
        }

        for(int i=1; i<=num; i++) {
            sb.append((result[i] + time[i]) + "\n");
        }

        System.out.println(sb);

    }
}
