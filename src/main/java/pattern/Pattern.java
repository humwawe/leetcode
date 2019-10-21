package pattern;

/**
 * @author hum
 */
public class Pattern {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int[] dp = new int[len];
        int min = Integer.MAX_VALUE;
        dp[0] = min;
        for (int i = 1; i < len; i++) {
            min = Math.min(min, nums[i - 1]);
            dp[i] = min;
        }
        for (int i = 1; i < len; i++) {
            if (dp[i] < nums[i]) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[j] > dp[i] && nums[j] < nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
