package Level2;

import java.util.LinkedList;

public class Cache {
    static public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> cache = new LinkedList<>();

        if(cacheSize == 0) {
            answer = cities.length * 5;
            return answer;
        }

        String[] cityArr = new String[cities.length];

        for(int i=0; i<cities.length; i++) {
            cityArr[i] = cities[i].toLowerCase();
        }

        int index;
        for(int i=0; i<cityArr.length; i++) {
            index = cache.indexOf(cityArr[i]);

            if(index == -1) {
                if(cache.size() < cacheSize) {
                    cache.add(cityArr[i]);
                } else {
                    cache.removeFirst();
                    cache.add(cityArr[i]);
                }
                answer += 5;
            } else {
                cache.remove(index);
                cache.add(cityArr[i]);
                answer += 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
}
