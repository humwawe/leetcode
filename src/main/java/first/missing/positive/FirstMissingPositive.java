package first.missing.positive;

/**
 * @author hum
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] > 0 && nums[index] < nums.length && nums[nums[index] - 1] != nums[index]) {
                int rightIndex = nums[index] - 1;
                int tmp = nums[index];
                nums[index] = nums[rightIndex];
                nums[rightIndex] = tmp;

            } else {
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
