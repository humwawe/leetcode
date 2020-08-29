package detect.cycles.in.two.d.grid;

/**
 * @author hum
 */
public class DetectCyclesIn2DGrid {
    boolean[][] vis = new boolean[505][505];
    int[][] fs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int row;
    int col;
    int idx = 0;

    public boolean containsCycle(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!vis[i][j]) {
                    idx += 2;
                    if (helper(grid, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private boolean helper(char[][] grid, int i, int j, int pi, int pj) {
        if (vis[i][j]) {
            return true;
        }
        vis[i][j] = true;
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x >= 0 && x < row && y >= 0 && y < col) {
                if (x == pi && y == pj) {
                    continue;
                }
                if (grid[x][y] == grid[i][j]) {
                    if (helper(grid, x, y, i, j)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }
}
