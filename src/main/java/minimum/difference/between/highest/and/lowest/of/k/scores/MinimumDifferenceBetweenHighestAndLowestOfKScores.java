package minimum.difference.between.highest.and.lowest.of.k.scores;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = (int) 1e9;
        for (int i = 0; i + k - 1 < nums.length; i++) {
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }
        return res;
    }
}
