package Level2;

public class FatigueLevel {
    static boolean[] visited;
    static int[][] data;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        data = dungeons.clone();

        dfs(0, k, 0);

        return answer;
    }

    public void dfs(int ans, int cur, int depth) {
        if(cur == 0 || depth == data.length) {
            answer = Math.max(ans, answer);
            return;
        }
        for(int i=0; i<data.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(cur >= data[i][0]) {
                    dfs(ans+1, cur-data[i][1], depth+1);
                } else {
                    dfs(ans, cur, depth+1);
                }
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        FatigueLevel fl = new FatigueLevel();
        int[][] arr = {{80,20}, {50,40}, {30,10}};
        System.out.println(fl.solution(80, arr));
    }
}
