package maximum.sum.of.three.non.overlapping.subarrays;

/**
 * @author hum
 */
public class MaximumSumOfThreeNonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[][] dp = new int[4][len + 1];
        int[][] prev = new int[4][len + 1];
        int[] sum = new int[len + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= 3; i++) {
            for (int j = i * k; j <= len - (3 - i) * k; j++) {
                dp[i][j] = dp[i][j - 1];
                prev[i][j] = prev[i][j - 1];
                int tmp = dp[i - 1][j - k] + sum[j] - sum[j - k];
                if (tmp > dp[i][j]) {
                    dp[i][j] = tmp;
                    prev[i][j] = j - k;
                }
            }
        }
        int i = prev[3][len];
        int j = prev[2][i];
        int l = prev[1][j];
        return new int[]{l, j, i};
    }
}
