package string.compression.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class StringCompressionII {
    String s;
    int[][][][] memo;

    public int getLengthOfOptimalCompression(String s, int k) {
        this.s = s;
        memo = new int[s.length() + 1][k + 1][28][12];
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                for (int l = 0; l < 28; l++) {
                    Arrays.fill(memo[i][j][l], -1);
                }
            }
        }
        return helper(0, k, 27, 0);
    }

    private int helper(int pos, int k, int prevChar, int prevCnt) {
        if (k < 0) {
            return 205;
        }
        if (pos == s.length()) {
            return memo[pos][k][prevChar][prevCnt] = getLen(prevChar, prevCnt);
        }
        if (memo[pos][k][prevChar][prevCnt] != -1) {
            return memo[pos][k][prevChar][prevCnt];
        }
        int res = helper(pos + 1, k - 1, prevChar, prevCnt);
        if (s.charAt(pos) - 'a' == prevChar) {
            res = Math.min(res, helper(pos + 1, k, prevChar, Math.min(11, prevCnt + 1)));
        } else {
            res = Math.min(res, helper(pos + 1, k, s.charAt(pos) - 'a', 1) + getLen(prevChar, prevCnt));
        }
        return memo[pos][k][prevChar][prevCnt] = res;
    }

    private int getLen(int prevChar, int prevCnt) {
        if (prevCnt == 0) {
            return 0;
        }
        if (prevCnt == 1) {
            return 1;
        }
        if (prevCnt < 10) {
            return 2;
        }
        return 3;
    }
}
