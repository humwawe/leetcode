package coin.change.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}
