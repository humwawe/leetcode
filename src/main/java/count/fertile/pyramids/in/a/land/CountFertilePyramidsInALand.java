package count.fertile.pyramids.in.a.land;

/**
 * @author hum
 */
public class CountFertilePyramidsInALand {
    public int countPyramids(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] f = new int[row][col];
        int res = 0;
        for (int i = row - 1; i >= 0; --i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0) {
                    f[i][j] = -1;
                } else if (i == row - 1 || j == 0 || j == col - 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = Math.min(Math.min(f[i + 1][j - 1], f[i + 1][j]), f[i + 1][j + 1]) + 1;
                    res += f[i][j];
                }
            }
        }
        // 倒金字塔
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0) {
                    f[i][j] = -1;
                } else if (i == 0 || j == 0 || j == col - 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = Math.min(Math.min(f[i - 1][j - 1], f[i - 1][j]), f[i - 1][j + 1]) + 1;
                    res += f[i][j];
                }
            }
        }
        return res;
    }
}
