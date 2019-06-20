package minimum.size.subarray.sum;

/**
 * @author hum
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if (tmp >= s) {
                return 1;
            }
            for (int j = i - 1; j >= 0 && i - j < result; j--) {
                tmp += nums[j];
                if (tmp >= s) {
                    result = i - j + 1;
                    break;
                }
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
