package maximum.score.from.removing.stones;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumScoreFromRemovingStones {
    public int maximumScore(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return nums[0] + nums[1];
        }
        return (nums[0] + nums[1] + nums[2]) / 2;
    }
}
