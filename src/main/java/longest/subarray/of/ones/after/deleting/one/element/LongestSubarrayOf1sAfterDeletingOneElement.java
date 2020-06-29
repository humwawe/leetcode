package longest.subarray.of.ones.after.deleting.one.element;

/**
 * @author hum
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int j = 0;
        int count = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            count += 1 - nums[i];
            while (count > 1) {
                if (nums[j] == 0) {
                    count--;
                }
                j++;
            }
            result = Math.max(result, i - j);
        }
        return result;
    }
}
