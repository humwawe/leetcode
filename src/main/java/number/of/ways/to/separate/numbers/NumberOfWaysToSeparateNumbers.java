package number.of.ways.to.separate.numbers;

import java.util.Arrays;

/**
 * @author hum
 */
public class NumberOfWaysToSeparateNumbers {
    public int numberOfCombinations(String num) {
        int mod = (int) (1e9 + 7);

        if (num.charAt(0) == '0') {
            return 0;
        }
        int len = num.length();

        int[][] lcp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (num.charAt(i) == num.charAt(j)) {
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
                }
            }
        }
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < len; i++) {
            if (num.charAt(i) == '0') {
                continue;
            }
            int preSum = 0;
            for (int j = i; j < len; j++) {
                int length = j - i + 1;
                dp[i][j] = preSum;
                if (i - length >= 0) {
                    if (lcp[i - length][i] >= length || num.charAt(i - length + lcp[i - length][i]) < num.charAt(i + lcp[i - length][i])) {
                        dp[i][j] = (dp[i][j] + dp[i - length][i - 1]) % mod;
                    }
                    preSum = (preSum + dp[i - length][i - 1]) % mod;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = (res + dp[i][len - 1]) % mod;
        }
        return res;
    }
}
