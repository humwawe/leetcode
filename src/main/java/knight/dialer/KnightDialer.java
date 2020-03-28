package knight.dialer;

import java.util.Arrays;

/**
 * @author hum
 */
public class KnightDialer {
    public int knightDialer(int n) {
        long[][] dp = new long[n + 1][10];
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][4] + dp[i - 1][6]) % mod;
            dp[i][1] = (dp[i - 1][8] + dp[i - 1][6]) % mod;
            dp[i][2] = (dp[i - 1][7] + dp[i - 1][9]) % mod;
            dp[i][3] = (dp[i - 1][4] + dp[i - 1][8]) % mod;
            dp[i][4] = (dp[i - 1][0] + dp[i - 1][3] + dp[i - 1][9]) % mod;
            dp[i][6] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][7]) % mod;
            dp[i][7] = (dp[i - 1][2] + dp[i - 1][6]) % mod;
            dp[i][8] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            dp[i][9] = (dp[i - 1][2] + dp[i - 1][4]) % mod;
        }
        System.out.println(Arrays.deepToString(dp));
        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n - 1][i] % mod;
        }
        return (int) (result % mod);
    }
}
