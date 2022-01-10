package stamping.the.grid;

/**
 * @author hum
 */
public class StampingTheGrid {
    public boolean possibleToStamp(int[][] grid, int h, int w) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] sum = new int[row + 1][col + 1];
        int[][] diff = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    int x = i + h, y = j + w;
                    if (x <= row && y <= col && (sum[x][y] - sum[x][j] - sum[i][y] + sum[i][j] == 0)) {
                        diff[i][j]++;
                        diff[i][y]--;
                        diff[x][j]--;
                        diff[x][y]++;
                    }
                }
            }
        }
        int[][] cnt = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                cnt[i][j] = cnt[i][j - 1] + cnt[i - 1][j] - cnt[i - 1][j - 1] + diff[i - 1][j - 1];
                if (cnt[i][j] == 0 && grid[i - 1][j - 1] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
