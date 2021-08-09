package minimum.total.space.wasted.with.k.resizing.operations;

/**
 * @author hum
 */
public class MinimumTotalSpaceWastedWithKResizingOperations {
    int len;
    int[] sum;
    int k;
    int[][] maxMat;
    int inf = (int) 1e9;
    Integer[][] memo;

    public int minSpaceWastedKResizing(int[] nums, int k) {
        len = nums.length;
        sum = new int[len + 1];
        maxMat = new int[len][len];
        memo = new Integer[len][len];
        this.k = k;
        for (int i = 0; i < len; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        for (int i = 0; i < len; i++) {
            int max = 0;
            for (int j = i; j < len; j++) {
                max = Math.max(max, nums[j]);
                maxMat[i][j] = max;
            }
        }
        return helper(0, k);
    }

    private int helper(int i, int k) {
        if (memo[i][k] != null) {
            return memo[i][k];
        }
        if (k == 0) {
            return memo[i][k] = maxMat[i][len - 1] * (len - i) - (sum[len] - sum[i]);
        }
        if (i == len - 1) {
            return 0;
        }
        int res = inf;
        for (int l = i + 1; l < len; l++) {
            res = Math.min(res, maxMat[i][l - 1] * (l - i) - (sum[l] - sum[i]) + helper(l, k - 1));
        }
        return memo[i][k] = res;
    }
}
