package champagne.tower;

/**
 * @author hum
 */
public class ChampagneTower {
    public double champagneTower(int poured, int queryRow, int queryGlass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;
        for (int i = 0; i <= queryRow; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1) {
                    double halfOver = (dp[i][j] - 1) / 2;
                    dp[i][j] = 1;
                    dp[i + 1][j] += halfOver;
                    dp[i + 1][j + 1] += halfOver;
                }
            }
        }
        return dp[queryRow][queryGlass];
    }
}
