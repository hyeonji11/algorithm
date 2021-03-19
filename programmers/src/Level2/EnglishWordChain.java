package Level2;

import java.util.HashSet;

public class EnglishWordChain {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        HashSet<String> hs = new HashSet<>();
        hs.add(words[0]);

        for(int i=1; i<words.length; i++) {
            if(!words[i-1].endsWith(words[i].substring(0, 1)) || !hs.add(words[i])) {
                answer[0] = (i+1)%n == 0 ? n : (i+1)%n;
                answer[1] = i/n +1;
                break;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        EnglishWordChain ewc = new EnglishWordChain();
        int[] result = ewc.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        System.out.println(result[0]+", "+result[1]);
    }
}
