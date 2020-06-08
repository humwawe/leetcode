package maximum.profit.in.job.scheduling;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class MaximumProfitInJobScheduling {
    Integer[] idx;
    int[] s;
    int[] e;
    int[] p;
    Integer[] memo;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        memo = new Integer[len];
        s = startTime;
        e = endTime;
        p = profit;
        idx = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(a -> startTime[a]));
        return helper(0);
    }

    private int helper(int i) {
        if (i == s.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        int res = helper(i + 1);
        for (int j = i + 1; j < s.length; j++) {
            if (s[idx[j]] >= e[idx[i]]) {
                res = Math.max(res, helper(j) + p[idx[i]]);
                break;
            }
        }
        return memo[i] = Math.max(res, p[idx[i]]);
    }
}
