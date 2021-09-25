package sum.of.beauty.in.the.array;

import java.util.Arrays;

/**
 * @author hum
 */
public class SumOfBeautyInTheArray {
    public int sumOfBeauties(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        Arrays.fill(min, (int) 1e8);
        for (int i = 1; i < len - 1; i++) {
            max[i] = Math.max(max[i - 1], nums[i - 1]);
        }
        for (int i = len - 2; i >= 1; i--) {
            min[i] = Math.min(min[i + 1], nums[i + 1]);
        }
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > max[i] && nums[i] < min[i]) {
                res += 2;
            } else if (nums[i] > nums[i - 1] && nums[i + 1] > nums[i]) {
                res++;
            }
        }

        return res;
    }
}
