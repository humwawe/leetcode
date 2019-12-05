package valid.triangle.number;

import java.util.Arrays;

/**
 * @author hum
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int len = nums.length;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = nums[i] + nums[j];
                for (int k = j + 1; k < len; k++) {
                    if (sum > nums[k]) {
                        result++;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
