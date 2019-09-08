package guess.number.higher.or.lower.II;

/**
 * @author hum
 */
public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int min = Integer.MAX_VALUE;
                for (int i = start; i < start + len - 1; i++) {
                    int tmp = i + Math.max(dp[start][i - 1], dp[i + 1][start + len - 1]);
                    min = Math.min(tmp, min);
                }
                dp[start][start + len - 1] = min;
            }
        }
        return dp[1][n];
    }
}
