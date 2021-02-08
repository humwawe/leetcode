package maximum.absolute.sum.of.any.subarray;

/**
 * @author hum
 */
public class MaximumAbsoluteSumOfAnySubarray {
    public int maxAbsoluteSum(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int res = 0;
        int min = 0;
        int max = 0;
        for (int i = 1; i <= len; i++) {
            res = Math.max(res, Math.abs(sum[i] - min));
            res = Math.max(res, Math.abs(sum[i] - max));
            max = Math.max(max, sum[i]);
            min = Math.min(min, sum[i]);
        }
        return res;
    }
}
