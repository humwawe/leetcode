package minimum.moves.to.equal.array.elements.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        int tmp = nums[nums.length / 2];
        for (int num : nums) {
            result += Math.abs(num - tmp);
        }
        return result;
    }
}
