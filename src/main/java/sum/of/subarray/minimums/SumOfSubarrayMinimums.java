package sum.of.subarray.minimums;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author hum
 */
public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] a) {
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && a[i] <= a[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[i] < a[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = len;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        long result = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < len; i++) {
            result += ((right[i] - i) * (i - left[i]) * a[i]) % mod;
            result %= mod;
        }
        return (int) (result % mod);
    }
}
