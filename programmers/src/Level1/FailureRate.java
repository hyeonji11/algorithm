package Level1;

import java.util.*;

public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int size = stages.length;

        HashMap<Integer, Double> hm = new HashMap<>();
        for(int i=1; i<=N; i++) {
            hm.put(i, 0.0);
        }

        for(int num: stages) {
            if(num == N+1) continue;
            hm.put(num, hm.get(num)+1);
        }

        for(int num: hm.keySet()) {
            double r;
            if(size == 0) {
                r = 0;
                continue;
            }
            r = hm.get(num)/size;
            size -= hm.get(num);
            hm.put(num, r);
        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                if(o2.getValue().compareTo(o1.getValue()) == 0) {
                    return o1.getKey().compareTo(o2.getKey());  //value가 같으면 key 오름차순
                } else
                    return o2.getValue().compareTo(o1.getValue());  //value 내림차순
            }
        });
        int idx = 0;
        for(Map.Entry<Integer, Double> map: list) {
            answer[idx] = map.getKey();
            idx++;
        }

        return answer;
    }
    public static void main(String[] args) {
        FailureRate fr = new FailureRate();
        fr.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
    }
}
