package unique.paths.III;

/**
 * @author hum
 */
public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int count = 1;
        int r = 0;
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                } else if (grid[i][j] == 1) {
                    r = i;
                    c = j;
                }
            }
        }
        return dfs(grid, r, c, count);
    }


    public int dfs(int[][] g, int i, int j, int count) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == -1) {
            return 0;
        }
        if (g[i][j] == 2) {
            return 0 == count ? 1 : 0;
        }
        int res = 0;
        g[i][j] = -1;
        res += dfs(g, i + 1, j, count - 1);
        res += dfs(g, i - 1, j, count - 1);
        res += dfs(g, i, j + 1, count - 1);
        res += dfs(g, i, j - 1, count - 1);
        g[i][j] = 0;
        return res;
    }
}
