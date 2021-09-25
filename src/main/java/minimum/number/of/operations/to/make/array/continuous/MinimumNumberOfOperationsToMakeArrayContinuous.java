package minimum.number.of.operations.to.make.array.continuous;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumNumberOfOperationsToMakeArrayContinuous {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] tmp = new int[len];
        int idx = 0;
        tmp[idx++] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                tmp[idx++] = nums[i];
            }
        }
        int j = 0;
        int res = len;
        for (int i = 0; i < idx; i++) {
            while (j < idx && tmp[j] <= tmp[i] + len - 1) {
                j++;
            }
            res = Math.min(res, len - (j - i));
        }
        return res;
    }
}
