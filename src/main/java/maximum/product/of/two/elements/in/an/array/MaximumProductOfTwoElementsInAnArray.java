package maximum.product.of.two.elements.in.an.array;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumProductOfTwoElementsInAnArray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }
}
