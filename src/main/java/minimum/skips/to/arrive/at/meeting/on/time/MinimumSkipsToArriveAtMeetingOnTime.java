package minimum.skips.to.arrive.at.meeting.on.time;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumSkipsToArriveAtMeetingOnTime {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int len = dist.length;
        long[][] dp = new long[len][len];
        long inf = (long) 1e15;
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], inf);
        }
        dp[0][0] = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < i) {
                    dp[i][j] = Math.min(dp[i][j], ((dp[i - 1][j] + dist[i - 1] - 1) / speed + 1) * speed);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + dist[i - 1]);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (dp[len - 1][i] + dist[len - 1] <= (long) hoursBefore * speed) {
                return i;
            }
        }
        return -1;
    }
}
