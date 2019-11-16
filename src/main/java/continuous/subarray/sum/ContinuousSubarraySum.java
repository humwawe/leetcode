package continuous.subarray.sum;

/**
 * @author hum
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 2; j <= len; j++) {
                int tmp = sum[j] - sum[i];
                if (k != 0 && tmp % k == 0) {
                    return true;
                }
                if (tmp == 0 && k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
