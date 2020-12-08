package wiggle.subsequence;

/**
 * @author hum
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] tmp = new int[len];
        int index = 0;
        for (int i = 0; i < len - 1; i++) {
            int t = nums[i + 1] - nums[i];
            if (t != 0) {
                tmp[index++] = nums[i + 1] - nums[i];
            }
        }
        if (index == 0) {
            return 1;
        }
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            if (tmp[i] * tmp[i - 1] < 0) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[index - 1];
    }
}
