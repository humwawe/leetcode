package largest.number.at.least.twice.of.others;

/**
 * @author hum
 */
public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        for (int num : nums) {
            if (num != max && num * 2 < max) {
                return -1;
            }
        }
        return index;
    }
}
