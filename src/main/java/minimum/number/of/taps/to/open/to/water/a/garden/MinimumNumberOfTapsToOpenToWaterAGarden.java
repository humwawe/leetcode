package minimum.number.of.taps.to.open.to.water.a.garden;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class MinimumNumberOfTapsToOpenToWaterAGarden {
    public int minTaps(int n, int[] ranges) {
        int inf = (int) 1e9;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            int l = Math.max(0, i - ranges[i]);
            if (dp[l] == inf) {
                continue;
            }
            for (int j = l; j <= i + ranges[i] && j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[l] + 1);
            }
        }
        if (dp[n] == inf) {
            return -1;
        }
        return dp[n];
    }

    public int minTaps2(int n, int[] ranges) {
        int inf = (int) 1e9;
        int[][] st = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            st[i][0] = i - ranges[i];
            st[i][1] = i + ranges[i];
        }
        Arrays.sort(st, Comparator.comparingInt(a -> a[0]));
        int end = 0;
        int idx = 0;
        int result = 0;
        while (idx <= n) {
            int max = -1;
            while (idx <= n && st[idx][0] <= end) {
                max = Math.max(max, st[idx][1]);
                idx++;
            }
            if (max == -1) {
                return -1;
            }
            end = max;
            if (end >= n) {
                return result;
            }
            result++;
        }
        return result;
    }

}
