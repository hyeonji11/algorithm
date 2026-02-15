package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16953 {
    static int A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int answer = -1;

//        HashMap<Long, Integer> map = new HashMap<>();
//
//        Queue<Long> queue = new LinkedList<>();
//        queue.offer((long) A);
//        long cur = A;
//
//        map.put(cur, 0);
//
//        while(!queue.isEmpty()) {
//            cur = queue.poll();
//            if(cur == B) {
//                answer = map.get(cur)+1;
//                break;
//            }
//
//            long multiple = cur*2;
//            long plus = Long.valueOf(cur+"1");
//
//            if(multiple <= B) {
//                queue.offer(multiple);
//                map.put(multiple, map.get(cur)+1);
//            }
//            if(plus <= B) {
//                queue.offer(plus);
//                map.put(plus, map.get(cur)+1);
//            }
//        }

        answer = greedy();
        System.out.println(answer);

    }

    static public int greedy() {
        int count = 1;
        while(B > A) {
            if(B % 2 == 0) {
                B = B/2;
            } else if(B % 10 == 1) {
                B = (B-1)/10;
            } else {
                return -1;
            }
            count++;
        }

        if(B==A) return count;
        else return -1;
    }

}
