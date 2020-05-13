package last.stone.weight.II;


/**
 * @author hum
 */
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int tmpSum = sum / 2 + 1;
        boolean[][] dp = new boolean[len + 1][tmpSum];
        dp[0][0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < tmpSum; j++) {
                dp[i][j] = dp[i][j] || dp[i - 1][j];
                if (j >= stones[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - stones[i - 1]];
                }
            }
        }
        for (int i = tmpSum - 1; i >= 0; i--) {
            if (dp[len][i]) {
                return sum - 2 * i;
            }
        }
        return 0;
    }
}
