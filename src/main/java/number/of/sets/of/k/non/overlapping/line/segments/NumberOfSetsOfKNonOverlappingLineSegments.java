package number.of.sets.of.k.non.overlapping.line.segments;

/**
 * @author hum
 */
public class NumberOfSetsOfKNonOverlappingLineSegments {
    public int numberOfSets(int n, int k) {
        long[][][] dp = new long[n + 1][k + 1][2];
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 1;
        }
        int mod = (int) 1e9 + 7;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j][1];
                dp[i][j][0] %= mod;
                dp[i][j][1] %= mod;
            }
        }
        return (int) ((dp[n - 1][k][0] + dp[n - 1][k][1]) % mod);
    }
}
