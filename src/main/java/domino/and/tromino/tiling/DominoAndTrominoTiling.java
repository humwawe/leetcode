package domino.and.tromino.tiling;

/**
 * @author hum
 */
public class DominoAndTrominoTiling {
    public int numTilings(int n) {
        if (n <= 1) {
            return 0;
        }
        int mod = 1000000007;
        long[][] dp = new long[n + 1][4];
        dp[1][0] = 1;
        dp[1][3] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = dp[i - 1][3] % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % mod;
        }
        return (int) dp[n][3];
    }
}
