package maximize.score.after.n.operations;

/**
 * @author hum
 */
public class MaximizeScoreAfterNOperations {
    public int maxScore(int[] nums) {
        int len = nums.length;
        int lim = 1 << len;
        int[] dp = new int[lim];
        for (int i = 0; i < lim; i++) {
            int order = Integer.bitCount(i) / 2;
            for (int j = 0; j < len; j++) {
                if (((i >> j) & 1) == 1) {
                    for (int k = j + 1; k < len; k++) {
                        if (((i >> k) & 1) == 1) {
                            dp[i] = Math.max(dp[i], dp[i - (1 << j) - (1 << k)] + gcd(nums[j], nums[k]) * order);
                        }
                    }
                }
            }
        }
        return dp[lim - 1];
    }

    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
