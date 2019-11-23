package student.attendance.record.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        long mod = 1000000007;
        if (n == 0) {
            return 0;
        }
        long[][][] dp = new long[n][3][2];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        dp[0][1][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][1][0] + dp[i - 1][2][0]) % mod;
            dp[i][0][1] = (dp[i - 1][0][1] + dp[i - 1][0][0] + dp[i - 1][1][1] + dp[i - 1][1][0] + dp[i - 1][2][1] + dp[i - 1][2][0]) % mod;
            dp[i][1][0] = dp[i - 1][0][0] % mod;
            dp[i][1][1] = dp[i - 1][0][1] % mod;
            dp[i][2][0] = dp[i - 1][1][0] % mod;
            dp[i][2][1] = dp[i - 1][1][1] % mod;
        }
        System.out.println(Arrays.deepToString(dp[1]));
        return (int) ((dp[n - 1][0][0] + dp[n - 1][0][1] + dp[n - 1][1][0] + dp[n - 1][1][1] + dp[n - 1][2][0] + dp[n - 1][2][1]) % mod);
    }
}
