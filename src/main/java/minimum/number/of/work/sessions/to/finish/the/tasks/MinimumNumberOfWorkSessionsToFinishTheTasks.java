package minimum.number.of.work.sessions.to.finish.the.tasks;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumNumberOfWorkSessionsToFinishTheTasks {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int lim = 1 << n;
        int[] dp = new int[lim];
        Arrays.fill(dp, (int) 1e8);
        dp[0] = 0;
        boolean[] st = new boolean[lim];
        for (int i = 0; i < lim; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    sum += tasks[j];
                }
            }
            if (sum <= sessionTime) {
                st[i] = true;
            }
        }
        for (int i = 0; i < lim; i++) {
            if (st[i]) {
                dp[i] = 1;
            }
            for (int sub = i; sub > 0; sub = (sub - 1) & i) {
                int t = sub ^ i;
                if (st[t]) {
                    dp[i] = Math.min(dp[i], dp[sub] + 1);
                }
            }
        }
        return dp[lim - 1];
    }
}
