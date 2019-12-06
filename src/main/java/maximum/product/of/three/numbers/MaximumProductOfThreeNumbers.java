package maximum.product.of.three.numbers;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int result = Integer.MIN_VALUE;
        int len = nums.length;
        result = Math.max(result, nums[0] * nums[1] * nums[len - 1]);
        result = Math.max(result, nums[len - 3] * nums[len - 2] * nums[len - 1]);
        return result;
    }
}
