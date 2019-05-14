package maximum.subarray;

/**
 * @author hum
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmp > 0) {
                tmp += nums[i];
            } else {
                tmp = nums[i];
            }
            max = Math.max(max, tmp);
        }
        return max;
    }
}
