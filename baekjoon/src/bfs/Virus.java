package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Virus {
    static Queue<Integer> queue = new LinkedList<>();
    static int count = 0;

    static void bfs(HashMap<Integer, ArrayList<Integer>> hm, boolean[] visited) {
        while(!queue.isEmpty()) {
            int num = queue.poll();
            if(!visited[num]) {
                visited[num] = true;
                count++;
                ArrayList<Integer> arr = hm.get(num);
                for(int n : arr) {
                    if(visited[n]) continue;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pcNum = Integer.parseInt(br.readLine());
        int netNum = Integer.parseInt(br.readLine());
        boolean visited[] = new boolean[pcNum+1];
        Arrays.fill(visited, false);

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();

        for(int i=0; i<netNum; i++) {
            String[] str = br.readLine().split(" ");
            ArrayList<Integer> list;
            int[] idx = {1, 0};

            for(int j=0; j<2; j++) {
                if(hm.containsKey(Integer.parseInt(str[j]))) {
                    list = hm.get(Integer.parseInt(str[j]));
                    list.add(Integer.parseInt(str[idx[j]]));
                } else {
                    list = new ArrayList<>();
                    list.add(Integer.parseInt(str[idx[j]]));
                }
                hm.put(Integer.parseInt(str[j]), list);
            }
        }

        if(hm.containsKey(1)) {
            queue.add(1);
            bfs(hm, visited);

            System.out.println(--count); //1번 컴 빼기
        } else {
            System.out.println(0);
        }
    }
}
