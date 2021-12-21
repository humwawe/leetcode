package number.of.smooth.descent.periods.of.a.stock;

/**
 * @author hum
 */
public class NumberOfSmoothDescentPeriodsOfAStock {
    public long getDescentPeriods(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = 1;
        long res = 1;
        for (int i = 1; i < len; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            res += dp[i];
        }
        return res;
    }
}
