package non.negative.integers.without.consecutive.ones;

import java.util.Arrays;

public class NonNegativeIntegersWithoutConsecutiveOnes {
    private int[][] memo;

    public int findIntegers(int num) {
        String s = Integer.toBinaryString(num);
        int len = s.length();
        memo = new int[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        int result = 0;
        boolean prev = false;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                if (prev) {
                    return result;
                }
                prev = true;
                result += helper(len - 1 - i, 0, 0);
            } else {
                prev = false;
            }
        }
        return result + 1;
    }

    public int helper(int len, int i, int prev) {
        if (i == len) {
            return 1;
        }
        if (memo[i][prev] != -1) {
            return memo[i][prev];
        }
        if (prev == 1) {
            return memo[i][prev] = helper(len, i + 1, 0);
        } else {
            return memo[i][prev] = helper(len, i + 1, 1) + helper(len, i + 1, 0);
        }
    }

}
