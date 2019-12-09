package decode.ways.II;

/**
 * @author hum
 */
public class DecodeWaysII {
    public int numDecodings(String s) {
        int mod = 1000000007;
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        long[] dp = new long[len + 1];
        dp[0] = 1;
        if (s.charAt(0) == '*') {
            dp[1] = 9;
        } else if (s.charAt(0) == '0') {
            return 0;
        } else {
            dp[1] = 1;
        }

        for (int i = 2; i <= len; i++) {
            char c = s.charAt(i);
            char prev = s.charAt(i - 1);
            if (c == '*') {
                dp[i] += dp[i - 1] * 9;
                if (prev == '1') {
                    dp[i] += dp[i - 2] * 9;
                }
                if (prev == '2') {
                    dp[i] += dp[i - 2] * 6;
                }
                if (prev == '*') {
                    dp[i] += dp[i - 2] * 15;
                }
            } else if (c == '0') {
                if (prev == '*') {
                    dp[i] += dp[i - 2] * 2;
                } else if (prev == '1' || prev == '2') {
                    dp[i] += dp[i - 2];
                } else {
                    return 0;
                }
            } else if (c >= '1' && c <= '6') {
                dp[i] += dp[i - 1];
                if (prev == '1' || prev == '2') {
                    dp[i] += dp[i - 2];
                }
                if (prev == '*') {
                    dp[i] += dp[i - 2] * 2;
                }
            } else {
                dp[i] += dp[i - 1];
                if (prev == '1' || prev == '*') {
                    dp[i] += dp[i - 2];
                }
            }
            dp[i] = dp[i] % mod;
        }
        return (int) dp[len];
    }
}
