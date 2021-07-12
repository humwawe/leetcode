package painting.a.grid.with.three.different.colors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class PaintingAGridWithThreeDifferentColors {
    int m;

    public int colorTheGrid(int m, int n) {
        this.m = m;
        int lim = (int) Math.pow(3, m);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lim; i++) {
            if (check(i)) {
                list.add(i);
            }
        }
        int[][] dp = new int[n][lim];
        for (Integer v : list) {
            dp[0][v] = 1;
        }
        int mod = (int) (1e9 + 7);
        for (int i = 1; i < n; i++) {
            for (int a : list) {
                if (dp[i - 1][a] == 0) {
                    continue;
                }
                for (int b : list) {
                    if (!check(a, b)) {
                        continue;
                    }
                    dp[i][b] = (dp[i][b] + dp[i - 1][a]) % mod;
                }
            }
        }
        long res = 0;
        for (Integer integer : list) {
            res = (res + dp[n - 1][integer]) % mod;
        }
        return (int) res;
    }

    private boolean check(int prev, int cur) {
        int[] s1 = helper(prev, 3);
        int[] s2 = helper(cur, 3);
        for (int i = 0; i < m; i++) {
            if (s1[i] == s2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int num) {
        int[] s = helper(num, 3);
        for (int i = 1; i < m; i++) {
            if (s[i] == s[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private int[] helper(int num, int r) {
        int[] res = new int[m];
        int idx = 0;
        while (num > 0) {
            res[idx++] = num % r;
            num /= r;
        }
        return res;
    }
}
