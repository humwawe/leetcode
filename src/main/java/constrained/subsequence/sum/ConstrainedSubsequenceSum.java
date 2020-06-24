package constrained.subsequence.sum;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hum
 */
public class ConstrainedSubsequenceSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int[] dp = new int[len];
        int result = nums[0];
        dp[0] = nums[0];
        deque.addLast(0);
        for (int i = 1; i < len; i++) {
            int idx = deque.getFirst();
            dp[i] = Math.max(nums[i], dp[idx] + nums[i]);
            result = Math.max(result, dp[i]);
            while (!deque.isEmpty() && (dp[i] >= dp[deque.getFirst()] || i - deque.getFirst() >= k)) {
                deque.pollFirst();
            }
            deque.addLast(i);
        }
        return result;
    }
}
