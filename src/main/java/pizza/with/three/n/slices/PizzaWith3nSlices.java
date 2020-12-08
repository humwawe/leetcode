package pizza.with.three.n.slices;

/**
 * @author hum
 */
public class PizzaWith3nSlices {
    Integer[][][] memo;
    int inf = (int) 1e8;

    public int maxSizeSlices(int[] slices) {
        int len = slices.length;
        int count = len / 3;
        memo = new Integer[len][count + 1][2];
        int t1 = helper(slices, 0, len - 1, 0, count);
        memo = new Integer[len][count + 1][2];
        int t2 = helper(slices, 1, len, 0, count);
        return Math.max(t1, t2);
    }

    private int helper(int[] t, int i, int j, int prev, int count) {
        if (i == j) {
            if (count == 0) {
                return 0;
            }
            return -inf;
        }
        if (count < 0) {
            return -inf;
        }
        if (memo[i][count][prev] != null) {
            return memo[i][count][prev];
        }
        int res = -inf;
        if (prev == 0) {
            res = Math.max(res, t[i] + helper(t, i + 1, j, 1, count - 1));
        }
        res = Math.max(res, helper(t, i + 1, j, 0, count));
        return memo[i][count][prev] = res;
    }
}
