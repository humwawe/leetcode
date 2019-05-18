package sort.colors;

/**
 * @author hum
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int left = -1;
        int right = nums.length;
        for (int i = 0; i < right; ) {
            if (nums[i] == 0) {
                if (i != left + 1) {
                    nums[left + 1] = 0;
                    nums[i] = 1;
                }
                left++;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[right - 1];
                nums[right - 1] = 2;
                right--;
            } else {
                i++;
            }
        }
    }
}
