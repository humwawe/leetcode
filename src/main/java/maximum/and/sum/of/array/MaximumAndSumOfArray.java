package maximum.and.sum.of.array;

/**
 * @author hum
 */
public class MaximumAndSumOfArray {
    public int maximumANDSum(int[] nums, int numSlots) {
        int res = 0;
        int[] dp = new int[1 << (numSlots * 2)];
        for (int i = 0; i < dp.length; i++) {
            int c = Integer.bitCount(i);
            if (c >= nums.length) {
                continue;
            }
            for (int j = 0; j < numSlots * 2; ++j) {
                if (((i >> j) & 1) == 0) {
                    int s = i | (1 << j);
                    dp[s] = Math.max(dp[s], dp[i] + ((j / 2 + 1) & nums[c]));
                    res = Math.max(res, dp[s]);
                }
            }
        }
        return res;
    }
}
