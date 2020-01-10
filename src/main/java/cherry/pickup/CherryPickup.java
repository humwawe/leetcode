package cherry.pickup;

import java.util.Arrays;

/**
 * @author hum
 */
public class CherryPickup {
    int[][][] memo;
    int len;

    public int cherryPickup(int[][] grid) {
        len = grid.length;
        memo = new int[len][len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
            }
        }
        return Math.max(0, helper(grid, 0, 0, 0));
    }

    private int helper(int[][] grid, int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if (r1 == len || r2 == len || c1 == len || c2 == len || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -10000;
        }
        if (r1 == len - 1 && c1 == len - 1 && r2 == len - 1 && c2 == len - 1) {
            return grid[r1][c1];
        }
        if (memo[r1][c1][r2] != Integer.MIN_VALUE) {
            return memo[r1][c1][r2];
        }
        int res = 0;
        if (r1 == r2) {
            res += grid[r1][c1];
        } else {
            res += grid[r1][c1] + grid[r2][c2];
        }
        return memo[r1][c1][r2] = res + Math.max(Math.max(helper(grid, r1, c1 + 1, r2 + 1), helper(grid, r1 + 1, c1, r2 + 1)),
                Math.max(helper(grid, r1, c1 + 1, r2), helper(grid, r1 + 1, c1, r2)));
    }
}
