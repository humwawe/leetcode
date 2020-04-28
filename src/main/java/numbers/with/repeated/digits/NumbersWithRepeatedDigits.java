package numbers.with.repeated.digits;

import java.util.Arrays;

/**
 * @author hum
 */
public class NumbersWithRepeatedDigits {
    int[] num = new int[11];
    int[][][][][] memo = new int[11][1030][2][2][2];

    public int numDupDigitsAtMostN(int n) {
        int index = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 1030; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        Arrays.fill(memo[i][j][k][l], -1);
                    }
                }
            }
        }
        while (n > 0) {
            num[index++] = n % 10;
            n /= 10;
        }
        return helper(index, 0, false, true, true);
    }

    private int helper(int index, int sta, boolean f, boolean lead, boolean lim) {
        if (index == 0) {
            if (f) {
                return memo[index][sta][f ? 1 : 0][lead ? 1 : 0][lim ? 1 : 0] = 1;
            }
            return memo[index][sta][f ? 1 : 0][lead ? 1 : 0][lim ? 1 : 0] = 0;
        }
        if (memo[index][sta][f ? 1 : 0][lead ? 1 : 0][lim ? 1 : 0] != -1) {
            return memo[index][sta][f ? 1 : 0][lead ? 1 : 0][lim ? 1 : 0];
        }
        int up = lim ? num[index - 1] : 9;
        int res = 0;
        for (int i = 0; i <= up; i++) {
            if (lead && i == 0) {
                res += helper(index - 1, sta, f, true, lim && i == up);
            } else {
                res += helper(index - 1, sta | 1 << i, f || ((sta >> i & 1) == 1), false, lim && i == up);
            }
        }
        return memo[index][sta][f ? 1 : 0][lead ? 1 : 0][lim ? 1 : 0] = res;
    }
}
