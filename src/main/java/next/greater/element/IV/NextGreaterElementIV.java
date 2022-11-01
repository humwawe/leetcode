package next.greater.element.IV;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author PF-2CRL0N
 */
public class NextGreaterElementIV {
  public int[] secondGreaterElement(int[] nums) {
    int len = nums.length;
    int[] right = new int[len];
    Stack<Integer> stack = new Stack<>();
    for (int i = len - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        right[i] = len;
      } else {
        right[i] = stack.peek();
      }
      stack.push(i);
    }

    int[][] q = new int[len][2];
    for (int i = 0; i < len; i++) {
      q[i][0] = i;
      q[i][1] = right[i];
    }
    Arrays.sort(q, (x, y) -> y[1] - x[1]);

    int[] res = new int[len];
    Arrays.fill(res, -1);

    stack.clear();

    int j = 0;

    for (int i = len - 1; i >= 0; i--) {
      while (j < len && q[j][1] >= i) {
        if (!stack.isEmpty() && nums[stack.get(0)] > nums[q[j][0]]) {
          res[q[j][0]] = helper(nums[q[j][0]], nums, stack);
        }
        j++;
      }
      while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
        stack.pop();
      }
      stack.push(i);
    }

    return res;
  }

  private int helper(int x, int[] nums, Stack<Integer> st) {
    int l = 0;
    int r = st.size() - 1;
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (x < nums[st.get(mid)]) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return nums[st.get(l)];
  }
}
