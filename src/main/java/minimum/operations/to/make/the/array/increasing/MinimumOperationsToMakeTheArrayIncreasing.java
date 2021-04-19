package minimum.operations.to.make.the.array.increasing;

/**
 * @author hum
 */
public class MinimumOperationsToMakeTheArrayIncreasing {
    public int minOperations(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[i - 1]) {
                int tmp = nums[i - 1] + 1 - nums[i];
                res += tmp;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }
}
