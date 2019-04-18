package three_sum_closest;

import java.util.Arrays;

/**
 * @author hum
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (Math.abs(result - target) > Math.abs(temp - target)) {
                    result = temp;
                }
                if (temp > target) {
                    right--;
                } else if (temp < target) {
                    left++;
                } else {
                    return temp;
                }
            }

        }
        return result;
    }


}
