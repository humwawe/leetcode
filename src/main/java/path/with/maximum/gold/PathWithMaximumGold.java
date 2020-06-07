package path.with.maximum.gold;

/**
 * @author hum
 */
public class PathWithMaximumGold {
    int result = 0;
    int[][] fs = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public int getMaximumGold(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int x = 0;
        int y = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    int[][] vis = new int[row][col];
                    x = i;
                    y = j;
                    helper(grid, x, y, vis, 0);
                }
            }
        }
        return result;
    }

    private void helper(int[][] grid, int x, int y, int[][] vis, int sum) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || vis[x][y] != 0 || grid[x][y] == 0) {
            result = Math.max(result, sum);
            return;
        }
        vis[x][y] = 1;
        for (int[] f : fs) {
            int newX = x + f[0];
            int newY = y + f[1];
            helper(grid, newX, newY, vis, sum + grid[x][y]);
        }
        vis[x][y] = 0;
    }
}
