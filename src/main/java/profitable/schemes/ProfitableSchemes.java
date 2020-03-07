package profitable.schemes;

import java.util.Arrays;

/**
 * @author hum
 */
public class ProfitableSchemes {
    long[][][] memo;
    int mod = (int) (1e9 + 7);

    public int profitableSchemes(int g, int p, int[] group, int[] profit) {
        int len = group.length;
        memo = new long[len + 1][101][105];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < 101; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return (int) (helper(g, p, group, profit, 0, 0, 0) % mod);
    }

    private long helper(int g, int p, int[] group, int[] profit, int i, int gg, int pp) {
        if (i == group.length) {
            if (gg <= g && pp >= p) {
                return 1;
            } else {
                return 0;
            }
        }
        if (gg > g) {
            return 0;
        }
        if (memo[i][gg][pp] != -1) {
            return memo[i][gg][pp];
        }
        long res = 0;
        res += helper(g, p, group, profit, i + 1, gg + group[i], pp + profit[i] > 102 ? 102 : pp + profit[i]);
        res += helper(g, p, group, profit, i + 1, gg, pp);
        return memo[i][gg][pp] = res % mod;
    }
}
