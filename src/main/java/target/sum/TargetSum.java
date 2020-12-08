package target.sum;

/**
 * @author hum
 */
public class TargetSum {
    int result = 0;
    int[] tmp;

    public int findTargetSumWays(int[] nums, int s) {
        int len = nums.length;
        tmp = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            tmp[i] += tmp[i + 1] + nums[i];

        }
        helper(nums, 0, 0, s);
        return result;
    }

    private void helper(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            if (sum == target) {
                result++;
            }
            return;
        }
        if (sum + tmp[i] < target || sum - tmp[i] > target) {
            return;
        }
        helper(nums, i + 1, sum - nums[i], target);
        helper(nums, i + 1, sum + nums[i], target);


    }
}
