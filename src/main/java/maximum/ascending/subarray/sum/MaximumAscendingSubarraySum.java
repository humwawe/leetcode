package maximum.ascending.subarray.sum;

/**
 * @author hum
 */
public class MaximumAscendingSubarraySum {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
