package burst.balloons;

/**
 * @author hum
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] nn = new int[n + 2];
        nn[0] = nn[n + 1] = 1;
        System.arraycopy(nums, 0, nn, 1, n);

        for (int len = 2; len < n + 2; ++len) {
            for (int i = 0; i + len < n + 2; ++i) {
                int j = i + len;
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nn[i] * nn[k] * nn[j]);
                }
            }
        }
        return dp[0][n + 1];

//        int len = nums.length;
//        int[][] memo = new int[len + 2][len + 2];
//        return helper(nums, 0, len - 1, memo);
    }

    private int helper(int[] nums, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        for (int k = i; k <= j; k++) {
            int left = helper(nums, i, k - 1, memo);
            int right = helper(nums, k + 1, j, memo);
            int l = 1, r = 1;
            if (i != 0) {
                l = nums[i - 1];
            }
            if (j != nums.length - 1) {
                r = nums[j + 1];
            }
            int delta = l * nums[k] * r;
            memo[i][j] = Math.max(memo[i][j], left + right + delta);
        }
        return memo[i][j];
    }
}
