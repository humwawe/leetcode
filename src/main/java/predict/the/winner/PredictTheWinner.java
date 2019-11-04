package predict.the.winner;

/**
 * @author hum
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length - 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int first = helper(nums, 0, len);
        return first >= sum - first;
    }

    private int helper(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }
        if (i + 1 == j) {
            return Math.max(nums[i], nums[j]);
        }
        int s1 = nums[i] + Math.min(helper(nums, i + 1, j - 1), helper(nums, i + 2, j));
        int s2 = nums[j] + Math.min(helper(nums, i + 1, j - 1), helper(nums, i, j - 2));
        return Math.max(s1, s2);
    }

    private int helper2(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }
        return Math.max(nums[i] - helper2(nums, i + 1, j), nums[j] - helper2(nums, i, j - 1));
    }
}
