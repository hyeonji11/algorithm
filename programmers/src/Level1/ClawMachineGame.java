package Level1;

import java.util.Stack;

public class ClawMachineGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int value: moves) {
            for(int i=0; i<board.length; i++) {
                if(board[i][value-1] != 0) {
                    if(!stack.isEmpty()) {
                        if(stack.peek() == board[i][value-1]) {
                            stack.pop();
                            board[i][value-1] = 0;
                            answer++;
                            break;
                        }
                    }
                    stack.push(board[i][value-1]);
                    board[i][value-1] = 0;
                    break;
                }

            }
        }

        return answer*2;
    }

    public static void main(String[] args) {
        ClawMachineGame cmg = new ClawMachineGame();

        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(cmg.solution(board, moves));
    }
}
