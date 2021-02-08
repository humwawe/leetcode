package check.array.is.sorted.and.rotated;

/**
 * @author hum
 */
public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[(i + 1) % len]) {
                res++;
            }
        }
        return res <= 1;
    }
}
