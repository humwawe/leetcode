package tallest.billboard;

import java.util.Arrays;

/**
 * @author hum
 */
public class TallestBillboard {
    public int tallestBillboard(int[] rods) {
        int len = rods.length;
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        int[][] dp = new int[len + 1][sum + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= len; i++) {
            int h = rods[i - 1];
            for (int j = 0; j <= sum - h; j++) {
                if (dp[i - 1][j] < 0) {
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j + h] = Math.max(dp[i][j + h], dp[i - 1][j]);
                dp[i][Math.abs(j - h)] = Math.max(dp[i][Math.abs(j - h)], dp[i - 1][j] + Math.min(j, h));
            }
        }
        return dp[len][0];
    }
}
