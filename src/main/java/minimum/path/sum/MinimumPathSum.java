package minimum.path.sum;

/**
 * @author hum
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || (grid.length == 1 && grid[0].length == 0)) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        result[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            result[0][i] = result[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            result[i][0] = result[i - 1][0] + grid[i][0];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
            }
        }
        return result[m - 1][n - 1];

    }
}
