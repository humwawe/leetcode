package reducing.dishes;

import java.util.Arrays;

/**
 * @author hum
 */
public class ReducingDishes {
    Integer[][] memo = new Integer[505][505];

    public int maxSatisfaction(int[] satisfaction) {
        int len = satisfaction.length;
        Arrays.sort(satisfaction);
        return helper(satisfaction, 0, 1);
    }

    private int helper(int[] satisfaction, int i, int j) {
        if (i == satisfaction.length) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int res = helper(satisfaction, i + 1, j);
        res = Math.max(res, satisfaction[i] * j + helper(satisfaction, i + 1, j + 1));
        return memo[i][j] = res;
    }
}
