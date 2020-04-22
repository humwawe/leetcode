package number.of.squareful.arrays;

import java.util.Arrays;

/**
 * @author hum
 */
public class NumberOfSquarefulArrays {
    int[][][] memo;

    public int numSquarefulPerms(int[] a) {
        int len = a.length;
        memo = new int[len][len + 1][1 << len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= len; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        Arrays.sort(a);
        return helper(a, 0, 0, len);
    }

    private int helper(int[] a, int pos, int state, int prev) {
        if (pos == a.length) {
            return 1;
        }
        if (memo[pos][prev][state] != -1) {
            return memo[pos][prev][state];
        }
        int res = 0;
        int last = -1;
        for (int i = 0; i < a.length; i++) {
            if (((state >> i) & 1) == 1) {
                continue;
            }
            if (last == a[i]) {
                continue;
            }
            if (prev != a.length) {
                int tmp = (int) Math.sqrt(a[i] + a[prev]);
                if (tmp * tmp == a[i] + a[prev]) {
                    res += helper(a, pos + 1, state | (1 << i), i);
                }
            } else {
                res += helper(a, pos + 1, state | (1 << i), i);
            }
            last = a[i];
        }
        return memo[pos][prev][state] = res;
    }
}
