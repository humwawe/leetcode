package four.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int targetCD = target - nums[i] - nums[j];
                        int left = j + 1;
                        int right = nums.length - 1;
                        while (left < right) {
                            if (nums[left] + nums[right] == targetCD) {
                                results.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                while (left < right && nums[left] == nums[left + 1]) {
                                    left++;
                                }
                                while (left < right && nums[right] == nums[right - 1]) {
                                    right--;
                                }
                                left++;
                                right--;
                            } else if (nums[left] + nums[right] > targetCD) {
                                right--;
                            } else {
                                left++;
                            }
                        }

                    }
                }
            }
        }
        return results;
    }

}
