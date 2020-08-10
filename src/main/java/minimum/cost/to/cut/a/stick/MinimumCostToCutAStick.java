package minimum.cost.to.cut.a.stick;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumCostToCutAStick {
    int[] c;
    Integer[][] memo = new Integer[105][105];

    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        c = new int[len + 2];
        System.arraycopy(cuts, 0, c, 0, len);
        c[len] = 0;
        c[len + 1] = n;
        Arrays.sort(c);
        return helper(c, 0, len + 1);
    }

    private int helper(int[] c, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (i + 1 == j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int sum = (int) 1e9;
        for (int k = i + 1; k < j; k++) {
            sum = Math.min(sum, helper(c, i, k) + helper(c, k, j) + c[j] - c[i]);
        }
        return memo[i][j] = sum;
    }
}
