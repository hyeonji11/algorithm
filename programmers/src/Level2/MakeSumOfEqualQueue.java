package Level2;

import java.util.LinkedList;

public class MakeSumOfEqualQueue {
    static public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0;

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for(int i=0; i<queue1.length; i++) {
            list1.add(queue1[i]);
            list2.add(queue2[i]);

            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        for(int i=0; i<queue1.length; i++) {
            sum += queue1[i]+queue2[i];
        }
        sum /= 2;

        if(sum1 == sum) {
            return 0;
        }

        while(answer < (queue1.length+queue2.length)*2) {
            int val;
            if(sum1 > sum2) {
                val = list1.removeFirst();
                list2.add(val);
                sum1 -= val;
                sum2 += val;
            } else {
                val = list2.removeFirst();
                list1.add(val);
                sum2 -= val;
                sum1 += val;
            }
            answer++;

            if(sum1 == sum)
                break;

        }

        if(answer >= (queue1.length+queue2.length)*2) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] queue1 = {1, 1, 1, 1};
        int[] queue2 = {1, 1, 7, 1};

        System.out.println(solution(queue1, queue2));
    }
}
