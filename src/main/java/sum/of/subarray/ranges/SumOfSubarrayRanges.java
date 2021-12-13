package sum.of.subarray.ranges;

/**
 * @author hum
 */
public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        long res = 0;
        for (int i = 0; i < len; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                res += (long) max - min;
            }
        }
        return res;
    }
}
