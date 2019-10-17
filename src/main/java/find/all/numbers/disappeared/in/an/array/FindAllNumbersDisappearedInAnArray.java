package find.all.numbers.disappeared.in.an.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
                result.add(j + 1);
            }
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];

    }
}
