package maximum.xor.each.query;

/**
 * @author hum
 */
public class MaximumXorForEachQuery {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int len = nums.length;
        nums[0] ^= (1 << maximumBit) - 1;
        for (int i = 0; i < len - 1; i++) {
            nums[i + 1] ^= nums[i];
        }
        for (int i = 0; i < len / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[len - 1 - i];
            nums[len - 1 - i] = temp;
        }
        return nums;
    }
}
