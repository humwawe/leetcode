package distinct.subsequences.II;

/**
 * @author hum
 */
public class DistinctSubsequencesII {
    public int distinctSubseqII(String s) {
        int len = s.length();
        long[] dp = new long[len + 1];
        int[] tmp = new int[26];
        dp[0] = 1;
        int mod = (int) (1e9 + 7);
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] * 2 % mod;
            int c = s.charAt(i - 1) - 'a';
            if (tmp[c] != 0) {
                dp[i] = (dp[i] + mod - dp[tmp[c] - 1]) % mod;
            }
            tmp[c] = i;
        }
        return (int) (dp[len] % mod);
    }
}
