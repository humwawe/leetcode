package maximum.number.of.points.with.cost;

/**
 * @author hum
 */
public class MaximumNumberOfPointsWithCost {
    public long maxPoints(int[][] points) {
        int row = points.length;
        int col = points[0].length;
        long[][] dp = new long[2][col];
        long[][] max1 = new long[2][col + 1];
        long[][] max2 = new long[2][col + 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) {
                    dp[i % 2][j] = points[i][j];
                } else {
                    dp[i % 2][j] = Math.max(max1[(i - 1) % 2][j] - j, max2[(i - 1) % 2][j] + j) + points[i][j];
                }

                if (j == 0) {
                    max1[i % 2][j] = dp[i % 2][j];
                } else {
                    max1[i % 2][j] = Math.max(max1[i % 2][j - 1], dp[i % 2][j] + j);
                }
            }
            for (int j = col - 1; j >= 0; j--) {
                if (j == col - 1) {
                    max2[i % 2][j] = dp[i % 2][j] - j;
                } else {
                    max2[i % 2][j] = Math.max(max2[i % 2][j + 1], dp[i % 2][j] - j);
                }
            }
        }
        long max = 0;
        for (int i = 0; i < col; i++) {
            max = Math.max(max, dp[(row - 1) % 2][i]);
        }
        return max;
    }
}
