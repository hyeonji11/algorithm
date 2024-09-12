package Level2;

import java.util.HashMap;

public class DiscountEvent {

    static public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<10; i++) {
            map.merge(discount[i], 1, Integer::sum);
        }


        int target;

//        boolean isSame = check(want, number, map);

        if(check(want, number, map)) answer++;

        for(int i=10; i< discount.length; i++) {
            target = i-10;
            map.merge(discount[i], 1, Integer::sum);
            map.put(discount[target], map.get(discount[target])-1);

            if(check(want, number, map)) answer++;
        }


        return answer;
    }

    static public boolean check(String[] want, int[] number, HashMap<String, Integer> map) {
        boolean check = true;

        for(int j=0; j<number.length; j++) {
            if(map.containsKey(want[j])) {
                if(number[j] > map.get(want[j])) {
                    check = false;
                    break;
                }
            } else {
                check = false;
                break;
            }
        }

        return check;
//        if(check) answer++;
//        else check = true;
    }
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(solution(want, number, discount));
    }
}
