package subarray.with.elements.greater.than.varying.threshold;

import java.util.Stack;

/**
 * @author hum
 */
public class SubarrayWithElementsGreaterThanVaryingThreshold {
  public int validSubarraySize(int[] nums, int threshold) {
    int len = nums.length;
    int[] left = new int[len];
    int[] right = new int[len];

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < len; i++) {
      while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
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
      while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        right[i] = len;
      } else {
        right[i] = stack.peek();
      }
      stack.push(i);
    }

    for (int i = 0; i < len; i++) {
      if (nums[i] > threshold / (right[i] - left[i] - 1)) {
        return right[i] - left[i] - 1;
      }
    }
    return -1;

  }
}
