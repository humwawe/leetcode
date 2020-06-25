package longest.continuous.subarray.with.absolute.diff.less.than.or.equal.to.limit;

import java.util.TreeMap;

/**
 * @author hum
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        int j = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int result = 1;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) - 1);
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}
