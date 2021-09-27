package grid.game;

/**
 * @author hum
 */
public class GridGame {
    public long gridGame(int[][] grid) {
        int len = grid[0].length;
        long[][] sum = new long[2][len + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < len; j++) {
                sum[i][j + 1] = sum[i][j] + grid[i][j];
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            res = Math.min(res, Math.max(sum[0][len] - sum[0][i], sum[1][i - 1]));
        }
        return res;
    }
}
