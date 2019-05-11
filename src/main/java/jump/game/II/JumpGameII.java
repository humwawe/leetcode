package jump.game.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int start = 0, end = 0, max = 0;
        int result = 0;
        while (end < nums.length - 1) {
            for (int i = start; i <= end; i++) {
                max = Math.max(max, nums[i] + i);
            }
            start = end + 1;
            end = max;
            result++;
        }
        return result;
    }

    public int jump1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                result[i] = Integer.MAX_VALUE;
                continue;
            }
            int min = result[i + 1];
            if (nums[i] + i >= nums.length - 1) {
                min = 0;
            } else {
                for (int j = 1; j <= nums[i]; j++) {
                    min = Math.min(min, result[i + j]);
                }
            }

            if (min + 1 > 0) {
                result[i] = min + 1;
            } else {
                result[i] = Integer.MAX_VALUE;
            }

        }
        System.out.println(Arrays.toString(result));
        return result[0];
    }
}
