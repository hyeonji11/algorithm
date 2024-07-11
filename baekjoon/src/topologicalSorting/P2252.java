package topologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int num = Integer.parseInt(inputs[0]);
        int count = Integer.parseInt(inputs[1]);

        ArrayList<Integer>[] list = new ArrayList[num+1];
        int[] accessArr = new int[num+1];
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=num; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<count; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            list[a].add(b);
            accessArr[b]++;
        }

        for(int i=1; i<=num; i++) {
            if(accessArr[i] == 0) {
                queue.add(i);
            }
        }

        int now;
        while(!queue.isEmpty()) {
            now = queue.poll();
            sb.append(now).append(" ");
            for(int value : list[now]) {
                accessArr[value]--;
                if(accessArr[value] == 0) {
                    queue.add(value);
                }
            }
        }

        System.out.println(sb);
    }
}
