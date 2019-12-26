package max.area.of.island;

/**
 * @author hum
 */
public class MaxAreaOfIsland {
    int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int count;

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    helper(grid, i, j);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    private void helper(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        count++;
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x >= 0 && x < grid.length & y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                helper(grid, x, y);
            }
        }
    }
}
