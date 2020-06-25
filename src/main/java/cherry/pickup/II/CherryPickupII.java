package cherry.pickup.II;

/**
 * @author hum
 */
public class CherryPickupII {
    int row;
    int col;
    Integer[][][] memo = new Integer[75][75][75];

    public int cherryPickup(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        return helper(grid, 0, 0, col - 1);
    }

    private int helper(int[][] grid, int i, int i1, int i2) {
        if (i == row) {
            return 0;
        }
        if (memo[i][i1][i2] != null) {
            return memo[i][i1][i2];
        }
        int res = 0;
        if (i1 != i2) {
            res += grid[i][i1] + grid[i][i2];
        } else {
            res += grid[i][i1];
        }
        int tmp = 0;
        for (int j = -1; j <= 1; j++) {
            for (int k = -1; k <= 1; k++) {
                if (i1 + j < 0 || i1 + j >= col) {
                    continue;
                }
                if (i2 + k < 0 || i2 + k >= col) {
                    continue;
                }
                tmp = Math.max(tmp, helper(grid, i + 1, i1 + j, i2 + k));
            }
        }
        return memo[i][i1][i2] = res + tmp;
    }
}
