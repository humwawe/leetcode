package stone.game.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class StoneGameII {
    int[] sum;
    Integer[][] memo;

    public int stoneGameII(int[] piles) {

        int len = piles.length;
        memo = new Integer[len][len * 2];
        sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + piles[i - 1];
        }
        System.out.println((helper(piles, 0, 1)));
        return (helper(piles, 0, 1) + sum[len]) / 2;
    }

    private int helper(int[] piles, int i, int m) {
        if (i >= piles.length) {
            return 0;
        }
        if (memo[i][m] != null) {
            return memo[i][m];
        }
        int res = Integer.MIN_VALUE;
        for (int j = 1; j <= 2 * m && i + j <= piles.length; j++) {
            res = Math.max(res, sum[i + j] - sum[i] - helper(piles, i + j, Math.max(j, m)));
        }
        return memo[i][m] = res;
    }
}
