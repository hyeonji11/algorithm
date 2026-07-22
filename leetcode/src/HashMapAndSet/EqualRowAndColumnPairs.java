package HashMapAndSet;

import java.util.Arrays;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int count = 0;

        int[][] column = new int[grid.length][grid.length];
        for(int c=0; c<grid.length; c++) {
            for(int r=0; r<grid.length; r++) {
                column[c][r] = grid[r][c];
            }
        }

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid.length; j++) {
                if(Arrays.equals(grid[i], column[j])) count++;
            }
        }

        return count;
    }
}
