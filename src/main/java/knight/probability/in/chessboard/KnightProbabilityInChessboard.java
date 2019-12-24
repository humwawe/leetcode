package knight.probability.in.chessboard;

/**
 * @author hum
 */
public class KnightProbabilityInChessboard {
    private double[][][] dp;
    private int[][] fs = new int[][]{{-1, -2}, {-2, -1}, {1, -2}, {-2, 1}, {-1, 2}, {2, -1}, {1, 2}, {2, 1}};

    public double knightProbability(int n, int k, int r, int c) {
        dp = new double[n][n][k + 1];
        return helper(n, k, r, c);
    }

    public double helper(int n, int k, int r, int c) {
        if (dp[r][c][k] - 0.0d > 0.000001d) {
            return dp[r][c][k];
        }
        if (k == 0) {
            return 1;
        }
        double res = 0.0d;
        for (int[] f : fs) {
            int newX = r + f[0];
            int newY = c + f[1];
            if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                res += helper(n, k - 1, newX, newY);
            }

        }
        return dp[r][c][k] = res / 8.0d;
    }
}
