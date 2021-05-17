package maximum.subarray.min.product;

import java.util.Stack;

/**
 * @author hum
 */
public class MaximumSubarrayMinProduct {
    public int maxSumMinProduct(int[] nums) {
        int len = nums.length;
        int[] l = new int[len];
        int[] r = new int[len];
        long[] sum = new long[len + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            l[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            r[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        long res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, (sum[r[i]] - sum[l[i] + 1]) * nums[i]);
        }
        int mod = (int) (1e9 + 7);
        return (int) (res % mod);
    }
}
