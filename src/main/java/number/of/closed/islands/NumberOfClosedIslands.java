package number.of.closed.islands;

/**
 * @author hum
 */
public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    if (helper(grid, i, j)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private boolean helper(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] != 0) {
            return true;
        }
        grid[i][j] = 2;
        boolean f1 = helper(grid, i + 1, j);
        boolean f2 = helper(grid, i - 1, j);
        boolean f3 = helper(grid, i, j + 1);
        boolean f4 = helper(grid, i, j - 1);
        return f1 && f2 && f3 && f4;
    }
}
