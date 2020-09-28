package maximum.non.negative.product.in.a.matrix;

/**
 * @author hum
 */
public class MaximumNonNegativeProductInAMatrix {
    public int maxProductPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        long[][][] dp = new long[row + 1][col + 1][2];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int num = grid[i - 1][j - 1];
                if (i == 1 && j == 1) {
                    dp[i][j][0] = num;
                    dp[i][j][1] = num;
                } else if (i == 1) {
                    dp[i][j][0] = num * dp[i][j - 1][0];
                    dp[i][j][1] = num * dp[i][j - 1][1];
                } else if (j == 1) {
                    dp[i][j][0] = num * dp[i - 1][j][0];
                    dp[i][j][1] = num * dp[i - 1][j][1];
                } else if (num > 0) {
                    dp[i][j][0] = num * Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
                    dp[i][j][1] = num * Math.min(dp[i - 1][j][1], dp[i][j - 1][1]);
                } else if (num < 0) {
                    dp[i][j][0] = num * Math.min(dp[i - 1][j][1], dp[i][j - 1][1]);
                    dp[i][j][1] = num * Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
                }
            }
        }
        if (dp[row][col][0] < 0) {
            return -1;
        }
        int mod = (int) (1e9 + 7);
        return (int) (dp[row][col][0] % mod);
    }
}
