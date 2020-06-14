package minimum.falling.path.sum.II;

/**
 * @author hum
 */
public class MinimumFallingPathSumII {
    int len;
    int inf = (int) 1e9;
    Integer[][] memo;

    public int minFallingPathSum(int[][] arr) {
        len = arr.length;
        memo = new Integer[len][len + 1];
        return helper(arr, 0, len, true);
    }

    private int helper(int[][] arr, int i, int prev, boolean b) {
        if (i == len) {
            return 0;
        }
        if (!b && memo[i][prev] != null) {
            return memo[i][prev];
        }
        int res = inf;
        for (int j = 0; j < len; j++) {
            if (b && arr[i][j] == 0) {
                continue;
            }
            if (j == prev) {
                continue;
            }
            res = Math.min(res, arr[i][j] + helper(arr, i + 1, j, b && arr[i][j] == 0));
        }
        if (!b) {
            memo[i][prev] = res;
        }
        return res;
    }
}
