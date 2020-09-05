package minimum.number.of.days.to.disconnect.island;

/**
 * @author hum
 */
public class MinimumNumberOfDaysToDisconnectIsland {
    int row, col;
    boolean[][] vis;
    int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minDays(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        if (helper(grid)) {
            return 0;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (helper(grid)) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    private boolean helper(int[][] grid) {
        int cnt = 0;
        vis = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt != 1;
    }

    private void dfs(int[][] grid, int i, int j) {
        vis[i][j] = true;
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x >= 0 && x < row && y >= 0 && y < col) {
                if (grid[i][j] == 1 && !vis[x][y]) {
                    dfs(grid, x, y);
                }
            }
        }
    }
}
