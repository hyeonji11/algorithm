package bellmanFord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P11657 {
    public static class Edge {
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    static boolean isUpdate = false;
    static long[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int city = Integer.parseInt(inputs[0]);
        int bus = Integer.parseInt(inputs[1]);

        ArrayList<Edge> list = new ArrayList<>();
        result = new long[city+1];

        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;

        int a, b, time;
        for(int i=0; i<bus; i++) {
            inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);
            time = Integer.parseInt(inputs[2]);

            list.add(new Edge(a, b, time));
        }

        for(int i=1; i<city; i++) {
            bellmalFord(list);
        }
        isUpdate = false;
        bellmalFord(list);

        if(isUpdate) {
            System.out.println("-1");
        } else {
            for(int i=2; i<=city; i++) {
                if(result[i] == Integer.MAX_VALUE)
                    System.out.println("-1");
                else
                    System.out.println(result[i]);
            }
        }
    }

    public static void bellmalFord(ArrayList<Edge> list) {
        Edge cur;
        for(int i=0; i<list.size(); i++) {
            cur = list.get(i);
            if(result[cur.start] != Integer.MAX_VALUE && result[cur.end] > result[cur.start] + cur.time) {
                result[cur.end] = result[cur.start] + cur.time;
                isUpdate = true;
            }
        }
    }


}
