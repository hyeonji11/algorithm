package Level2;

import java.util.HashMap;

public class NewsClustering {
    static public int solution(String str1, String str2) {
        int answer = 0;

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> set = new HashMap<>();

        int num1 = 0;
        int num2 = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i=0; i<str1.length()-1; i++) {
            if(str1.substring(i, i+2).matches("[a-z]{2}")) {
                map1.merge(str1.substring(i, i+2), 1, Integer::sum);
            }
        }

        for(int i=0; i<str2.length()-1; i++) {
            if(str2.substring(i, i+2).matches("[a-z]{2}")) {
                map2.merge(str2.substring(i, i+2), 1, Integer::sum);
            }
        }

        for(String str : map1.keySet()) {
            set.put(str, map1.get(str));
        }
        for(String str : map2.keySet()) {
            if(set.containsKey(str)) {
                set.put(str, Math.max(map1.get(str), map2.get(str)));
            }else {
                set.put(str, map2.get(str));
            }
        }

        for(String str : map1.keySet()) {
            if(map2.containsKey(str)) {
                int val1 = map1.get(str);
                int val2 = map2.get(str);
                int min = Math.min(val1, val2);

                num1 += min;
            }
        }
        for(String str : set.keySet()) {
            num2 += set.get(str);
        }

        double similarity = 0.0;

        if(num1 == 0 && num2 == 0) {
            similarity = 1;
        } else {
            similarity = (double)num1/(double)num2;
        }

        answer = (int)(similarity*65536);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }
}
