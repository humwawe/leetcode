package find.all.duplicates.in.an.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
            i++;
        }
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                result.add(nums[j]);
            }
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
