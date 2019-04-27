package remove_duplicates_from_sorted_array;

/**
 * @author hum
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int count = 0;
        for (int i = 1; i < len - count; ) {
            if (nums[i] == nums[i - 1]) {
                count++;
                System.arraycopy(nums, i, nums, i - 1, len - count - (i - 1));
            } else {
                i++;
            }
        }
        return len - count;

    }

}
