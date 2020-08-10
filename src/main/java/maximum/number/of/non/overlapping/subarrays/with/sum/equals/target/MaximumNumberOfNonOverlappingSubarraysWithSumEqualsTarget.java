package maximum.number.of.non.overlapping.subarrays.with.sum.equals.target;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget {
    public int maxNonOverlapping(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int[] dp = new int[len + 1];
        int sum = 0;
        for (int i = 1; i <= len; i++) {
            sum += nums[i - 1];
            dp[i] = dp[i - 1];
            if (map.containsKey(sum - target)) {
                dp[i] = Math.max(dp[i - 1], dp[map.get(sum - target)] + 1);
            }
            map.put(sum, i);
        }
        return dp[len];
    }
}
