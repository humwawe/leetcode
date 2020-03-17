package valid.permutations.fo.di.sequence;

import java.util.Arrays;

/**
 * @author hum
 */
public class ValidPermutationsForDiSequence {

    public int numPermsDISequence(String s) {
        int len = s.length();
        int mod = (int) (1e9 + 7);
        int[][] dp = new int[len + 1][len + 1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i - 1) == 'D') {
                    for (int k = j; k < i; ++k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                } else {
                    for (int k = 0; k < j; ++k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        int result = 0;
        for (int x : dp[len]) {
            result += x;
            result %= mod;
        }
        return result;
    }
}
