package number.of.islands;

/**
 * @author hum
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void helper(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        helper(grid, i - 1, j);
        helper(grid, i, j - 1);
        helper(grid, i + 1, j);
        helper(grid, i, j + 1);
    }
}
