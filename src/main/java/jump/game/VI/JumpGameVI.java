package jump.game.VI;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hum
 */
public class JumpGameVI {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i < nums.length; i++) {
            while (!deque.isEmpty() && dp[i - 1] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i - 1);
            if (deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            dp[i] = dp[deque.peekFirst()] + nums[i];
        }
        return dp[nums.length - 1];
    }
}
