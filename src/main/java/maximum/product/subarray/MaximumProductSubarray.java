package maximum.product.subarray;

/**
 * @author hum
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int tmpMax = 1;
        int tmpMin = 1;
        for (int num : nums) {
            int tmp;
            if (num >= 0) {
                tmpMax = Math.max(num * tmpMax, num);
                tmpMin = Math.min(num * tmpMin, num);
            } else {
                tmp = tmpMax;
                tmpMax = Math.max(num * tmpMin, num);
                tmpMin = Math.min(num * tmp, num);
            }
            result = Math.max(result, tmpMax);
        }

        return result;
    }
}
