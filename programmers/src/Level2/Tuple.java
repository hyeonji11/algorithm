package Level2;

import java.util.*;

public class Tuple {
    public int[] solution(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        String str[] = s.replaceAll("[{}]", "").split(",");
        /*
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        람다식을 이용해 간단하게 길이를 기준으로 정렬 가능
         */
        for(int i=0; i<str.length; i++) {
            if(hm.containsKey(str[i])) {
                int count = hm.get(str[i]);
                hm.put(str[i], count+1);
            } else {
                hm.put(str[i], 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        int []answer = new int[list.size()];
        int idx = 0;
        for(Map.Entry<String, Integer> entry : list) {
            answer[idx++] = Integer.parseInt(entry.getKey());
        }

        return answer;
    }
    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        int arr[] = tuple.solution("{20,111},{111}");
        for(int num: arr) System.out.println(num);
    }
}
