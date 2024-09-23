package Level3;

public class IntegerTriangle {
    static public int solution(int[][] triangle) {
        int answer = -1;
        int[][] dp = new int[triangle.length][];

        for(int i=0; i<triangle.length; i++) {
            dp[i] = new int[i+1];
        }

        dp[0][0] = triangle[0][0];

        for(int i=0; i<triangle.length-1; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                dp[i+1][j] = Math.max(dp[i][j] + triangle[i+1][j], dp[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i][j] + triangle[i+1][j+1], dp[i+1][j+1]);
            }
        }

        int idx = triangle.length-1;
        for(int i=0; i<triangle.length; i++) {
            answer = Math.max(answer, dp[idx][i]);
        }


        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
