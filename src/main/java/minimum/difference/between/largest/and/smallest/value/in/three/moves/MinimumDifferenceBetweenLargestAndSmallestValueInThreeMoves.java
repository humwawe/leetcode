package minimum.difference.between.largest.and.smallest.value.in.three.moves;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 4) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 0; i <= 3; i++) {
            result = Math.min(result, nums[len - 4 + i] - nums[i]);
        }
        return result;
    }
}
