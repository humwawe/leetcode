package delete.and.earn;


/**
 * @author hum
 */
public class DeleteandEarn {
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10002];
        for (int num : nums) {
            dp[num]++;
        }
        for (int i = 2; i < 10001; i++) {
            dp[i] = Math.max(dp[i - 2] + dp[i] * i, dp[i - 1]);
        }
        return dp[10000];
    }

}
