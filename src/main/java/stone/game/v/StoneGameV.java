package stone.game.v;

/**
 * @author hum
 */
public class StoneGameV {
    int[] sum;
    Integer[][] memo = new Integer[505][505];

    public int stoneGameV(int[] stoneValue) {
        int len = stoneValue.length;
        sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + stoneValue[i];
        }
        return helper(stoneValue, 0, len - 1);
    }

    private int helper(int[] stoneValue, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int res = 0;
        for (int k = i; k < j; k++) {
            if (sum[k + 1] - sum[i] > sum[j + 1] - sum[k + 1]) {
                res = Math.max(res, helper(stoneValue, k + 1, j) + sum[j + 1] - sum[k + 1]);
            } else if (sum[k + 1] - sum[i] < sum[j + 1] - sum[k + 1]) {
                res = Math.max(res, helper(stoneValue, i, k) + sum[k + 1] - sum[i]);
            } else {
                int tmp = Math.max(helper(stoneValue, i, k) + sum[k + 1] - sum[i], helper(stoneValue, k + 1, j) + sum[j + 1] - sum[k + 1]);
                res = Math.max(res, tmp);
            }
        }
        return memo[i][j] = res;
    }
}
