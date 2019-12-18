package number.of.longest.increasing.subsequence;

import java.util.Arrays;

/**
 * @author hum
 */
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int dp[] = new int[len];
        int count[] = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == max) {
                result += count[i];
            }
        }
        return result;
    }
}
