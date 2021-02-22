package maximum.score.from.performing.multiplication.operations;

/**
 * @author hum
 */
public class MaximumScoreFromPerformingMultiplicationOperations {
    int[] mul;
    int[] nums;
    int n, m;
    Integer[][] memo;

    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        this.mul = multipliers;
        this.nums = nums;
        memo = new Integer[m][m];
        return helper(0, 0);
    }

    private int helper(int i, int j) {
        int idx = i + j;
        if (idx == m) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.max(helper(i + 1, j) + mul[idx] * nums[i], helper(i, j + 1) + mul[idx] * nums[n - 1 - j]);
    }
}
