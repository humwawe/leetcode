package k.inverse.pairs.array;

/**
 * @author hum
 */
public class KInversePairsArray {
    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        int mod = 1000000007;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= i) {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - i] + mod) % mod;
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
                }
            }
        }
        return (int) dp[n][k];
    }
}
