package minimum.cost.to.merge.stones;

/**
 * @author hum
 */
public class MinimumCostToMergeStones {
    private static final int INF = 0x3f3f3f3f;
    private int k;
    private int[] sum;
    private int[][][] memo;

    public int mergeStones(int[] stones, int k) {
        if (stones.length == 1) {
            return 0;
        }
        if (stones.length < k) {
            return -1;
        }
        int n = stones.length;
        this.k = k;
        sum = new int[n];
        sum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + stones[i];
        }
        memo = new int[n][n][k + 1];
        int res = helper(0, n - 1, 1);
        return res < INF ? res : -1;
    }

    private int helper(int i, int j, int k) {
        if (memo[i][j][k] != 0) {
            return memo[i][j][k];
        }
        if (j - i + 1 == k) {
            return 0;
        }
        if (j - i + 1 < k) {
            return INF;
        }
        if (k == 1) {
            return memo[i][j][k] = helper(i, j, this.k) + sum(i, j);
        }
        int res = INF;
        for (int l = i; l < j; l++) {
            res = Math.min(res, helper(i, l, 1) + helper(l + 1, j, k - 1));
        }
        return memo[i][j][k] = res;
    }

    private int sum(int i, int j) {
        return i == 0 ? sum[j] : sum[j] - sum[i - 1];
    }
}
