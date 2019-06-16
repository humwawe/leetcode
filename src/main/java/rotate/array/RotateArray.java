package rotate.array;

/**
 * @author hum
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        int i = 0, j = nums.length - 1 - k;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        i = nums.length - k;
        j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        i = 0;
        j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
