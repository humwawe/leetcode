package subarray.product.less.than.k;

/**
 * @author hum
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        int[] prod = new int[len + 1];
        int result = 0;
        dp[0] = 0;
        prod[0] = 1;
        for (int i = 1; i <= len; i++) {
            int index = dp[i - 1];
            int product = prod[i - 1] * nums[i - 1];
            while (product >= k && index < i) {
                product /= nums[index];
                index++;
            }
            dp[i] = index;
            prod[i] = product;
            result += i - index;
        }
        return result;
    }
}
