package Level3;

public class BallMoveSimulation {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = -1;

        int[] dir = {-1, 1, -1, 1};
        int row = 0;
        int col = 0;

        for(int i=0; i<queries.length; i++) {
            int num = queries[i][0];
            if(num < 2) {
                col += dir[num]*queries[i][1];
            } else {
                row += dir[num]*queries[i][1];
            }

            if(row < 0 || row >= n ) {

            }
        }
        

        return answer;
    }
    public static void main(String[] args) {
        BallMoveSimulation b = new BallMoveSimulation();
    }
}
