package longest.consecutive.sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        int result = 0;
        for (int num : nums) {
            if (numSet.remove(num)) {
                int count = 1;
                int cur = num;
                while (numSet.remove(--cur)) {
                    count++;
                }
                cur = num;
                while (numSet.remove(++cur)) {
                    count++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
