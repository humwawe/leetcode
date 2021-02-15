package count.number.of.homogenous.substrings;

/**
 * @author hum
 */
public class CountNumberOfHomogenousSubstrings {
    public int countHomogenous(String s) {
        int len = s.length();
        long[] dp = new long[len];
        dp[0] = 1;
        long res = 1;
        int mod = (int) (1e9 + 7);
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            if (s.charAt(i) == s.charAt(i - 1)) {
                dp[i] += dp[i - 1];
            }
            dp[i] %= mod;
            res += dp[i];
            res %= mod;
        }
        return (int) res % mod;
    }
}
