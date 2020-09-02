package maximum.length.of.subarray.with.positive.product;

/**
 * @author hum
 */
public class MaximumLengthOfSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int x = 0;
        int y = 0;
        int result = 0;
        for (int num : nums) {
            if (num > 0) {
                x++;
                if (y > 0) {
                    y++;
                }
            } else if (num < 0) {
                int tmp = x;
                if (y > 0) {
                    x = y + 1;
                } else {
                    x = 0;
                }
                y = tmp + 1;
            } else {
                x = 0;
                y = 0;
            }
            result = Math.max(result, x);
        }
        return result;
    }
}
