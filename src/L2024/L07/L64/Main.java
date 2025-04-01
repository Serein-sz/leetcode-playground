package L2024.L07.L64;

import utils.ArrayUtils;

/**
 * @author 王强
 * @since 2024/7/12
 */
public class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,2,2,6,4,1,6,2,9,9,5,8,4,4},
                {0,3,6,4,5,5,9,7,8,3,9,9,5,4},
                {6,9,0,7,2,2,5,6,3,1,0,4,2,5},
                {3,8,2,3,2,8,8,7,5,9,6,3,4,5},
                {4,0,1,3,9,2,0,1,6,7,9,2,8,9},
                {6,2,7,9,0,9,5,2,7,5,1,4,4,7},
                {9,8,3,3,0,6,8,0,8,8,3,5,7,3},
                {7,7,4,5,9,1,5,0,2,2,2,1,7,4},
                {5,1,3,4,1,6,0,4,3,8,4,3,9,9},
                {0,6,4,9,4,1,5,5,4,2,5,7,4,0},
                {0,1,6,6,4,9,2,7,8,2,1,3,3,7},
                {8,4,9,9,2,3,8,6,6,5,4,1,7,9},
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int ans = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int left = col > 0 ? grid[row][col - 1] : 0;
                int up = row > 0 ? grid[row - 1][col] : 0;
                if (col == 0) {
                    grid[row][col] += up;
                } else if (row == 0) {
                    grid[row][col] += left;
                } else {
                    grid[row][col] += Math.min(left, up);
                }
                ans = grid[row][col];
            }
        }
        for (int[] ints : grid) {
            ArrayUtils.println(ints);
        }
        return ans;
    }
}
