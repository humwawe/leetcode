package maximum.alternating.subsequence.sum;

/**
 * @author hum
 */
public class MaximumAlternatingSubsequenceSum {
    public long maxAlternatingSum(int[] nums) {
        int len = nums.length;
        long[][] dp = new long[len + 1][2];

        for (int i = 1; i <= len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - nums[i - 1]);
        }
        return Math.max(dp[len][0], dp[len][1]);
    }
}
