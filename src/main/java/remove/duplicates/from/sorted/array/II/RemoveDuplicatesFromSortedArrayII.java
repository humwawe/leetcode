package remove.duplicates.from.sorted.array.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
                count = 1;
            } else if (count < 2) {
                count++;
                nums[++i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;

    }
}
