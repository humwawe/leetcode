package split.array.largest.sum;

import java.util.Arrays;

/**
 * @author hum
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        int[][] dp = new int[len + 1][m + 1];
        sum[0] = 0;
        for (int i = 1; i <= len; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }
        }

        return dp[len][m];
    }

}
