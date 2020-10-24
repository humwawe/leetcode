package best.team.with.no.conflicts;

import java.util.Arrays;

/**
 * @author hum
 */
public class BestTeamWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        Integer[] idx = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (x, y) -> {
            int t = ages[x] - ages[y];
            if (t == 0) {
                return scores[x] - scores[y];
            } else {
                return t;
            }
        });
        int[] dp = new int[len];
        int result = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = scores[idx[i]];
            for (int j = 0; j < i; j++) {
                if (scores[idx[i]] > scores[idx[j]]) {
                    dp[i] = Math.max(dp[i], dp[j] + scores[idx[i]]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
