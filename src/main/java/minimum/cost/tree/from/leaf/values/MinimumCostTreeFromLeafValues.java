package minimum.cost.tree.from.leaf.values;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumCostTreeFromLeafValues {
    int[][] mx;
    int[][] memo;

    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        mx = new int[len][len];
        for (int i = 0; i < len; i++) {
            int m = arr[i];
            for (int j = i; j < len; j++) {
                m = Math.max(m, arr[j]);
                mx[i][j] = m;
            }
        }
        return helper(arr, 0, len - 1);
    }

    private int helper(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (i == j - 1) {
            return arr[i] * arr[j];
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int l = helper(arr, i, k);
            int r = helper(arr, k + 1, j);
            res = Math.min(res, l + r + mx[i][k] * mx[k + 1][j]);
        }
        return memo[i][j] = res;
    }
}
