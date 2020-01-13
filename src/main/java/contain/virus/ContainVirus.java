package contain.virus;

/**
 * @author hum
 */
public class ContainVirus {
    private int walls = 0;
    private int[][] fs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int row;
    private int col;
    private int color = -1;

    public int containVirus(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int result = 0;
        while (true) {
            int walls = helper(grid);
            if (walls == 0) {
                break;
            }
            result += walls;
        }
        return result;
    }

    private int helper(int[][] grid) {

        int res = 0;
        int maxArea = 0;
        int x = -1, y = -1;
        color = -1;
        int[][] vis = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    walls = 0;
                    int area = dfs(grid, vis, i, j);
                    if (area > maxArea) {
                        maxArea = area;
                        x = i;
                        y = j;
                        res = walls;
                    }
                }
                color--;
            }
        }
        if (x != -1) {
            buildWall(grid, x, y);
            vis = new int[row][col];
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    if (grid[i][j] == 1 && vis[i][j] == 0) {
                        spread(grid, vis, i, j);
                    }
                }
            }
        }
        return res;
    }

    private void spread(int[][] grid, int[][] vis, int i, int j) {
        if (grid[i][j] == 0) {
            grid[i][j] = 1;
            vis[i][j] = 1;
            return;
        }
        if (grid[i][j] != 1) {
            return;
        }
        vis[i][j] = 1;
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x >= 0 && x < row && y >= 0 && y < col && vis[x][y] == 0) {
                spread(grid, vis, x, y);
            }
        }
    }

    private void buildWall(int[][] grid, int i, int j) {
        grid[i][j] = -1;
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                buildWall(grid, x, y);
            }
        }
    }

    private int dfs(int[][] grid, int[][] vis, int i, int j) {
        if (grid[i][j] == 0) {
            walls++;
            if (vis[i][j] == color) {
                return 0;
            }
            vis[i][j] = color;
            return 1;
        }
        int res = 0;
        if (vis[i][j] == 0 && grid[i][j] == 1) {
            vis[i][j] = 1;
            for (int[] f : fs) {
                int x = i + f[0];
                int y = j + f[1];
                if (x >= 0 && x < row && y >= 0 && y < col) {
                    res += dfs(grid, vis, x, y);
                }
            }
        }
        return res;
    }
}
