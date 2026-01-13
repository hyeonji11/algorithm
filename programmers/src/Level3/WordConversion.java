package Level3;

public class WordConversion {
    boolean[] visited;
    String targetWord;
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {

        targetWord = target;
        visited = new boolean[words.length];
        dfs(begin, words, 0);


        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public void dfs(String currentWord, String[] words, int depth) {
        if(currentWord.equals(targetWord)) {
            answer = Math.min(answer, depth);
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(visited[i]) continue;

            if(isOneDifferent(currentWord, words[i])) {
                visited[i] = true;
                dfs(words[i], words, depth+1);
                visited[i] = false;
            }
        }
    }

    public boolean isOneDifferent(String current, String word) {
        int diff = 0;
        for(int i=0; i<current.length(); i++) {
            if(current.charAt(i) != word.charAt(i)) {
                diff++;
                if(diff > 1)
                    break;
            }
        }
        return diff == 1;
    }
}
