package sliding.window.maximum;

import java.util.LinkedList;

/**
 * @author hum
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        if (nums == null || nums.length < 2) {
            return nums;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!linkedList.isEmpty() && nums[linkedList.peekLast()] <= nums[i]) {
                linkedList.pollLast();
            }
            linkedList.addLast(i);
            if (linkedList.peek() <= i - k) {
                linkedList.poll();
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[linkedList.peek()];
            }
        }

        return result;
    }
}
