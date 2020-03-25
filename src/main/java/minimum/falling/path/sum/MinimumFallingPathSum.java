package minimum.falling.path.sum;

/**
 * @author hum
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] a) {
        int row = a.length;
        int col = a[0].length;
        if (row == 1) {
            return a[0][0];
        }
        int[][] dp = new int[row + 1][col];
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + a[i - 1][j];
                } else if (j == col - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + a[i - 1][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + a[i - 1][j];
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            result = Math.min(result, dp[row][i]);
        }
        return result;
    }
}
