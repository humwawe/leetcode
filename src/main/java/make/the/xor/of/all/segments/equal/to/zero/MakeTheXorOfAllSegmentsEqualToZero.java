package make.the.xor.of.all.segments.equal.to.zero;

import java.util.Arrays;

/**
 * @author hum
 */
public class MakeTheXorOfAllSegmentsEqualToZero {
    public int minChanges(int[] a, int k) {
        int[] dp = new int[1024];
        int inf = (int) 1e8;
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int i = 0; i < k; i++) {
            int[] temp = new int[1024];
            int all = 0;
            for (int j = i; j < a.length; j += k) {
                temp[a[j]]++;
                all++;
            }
            int[] ndp = new int[1024];

            int lMin = inf;
            for (int j = 0; j < 1024; j++) {
                lMin = Math.min(lMin, dp[j]);
            }
            lMin += all;
            Arrays.fill(ndp, lMin);

            for (int j = 0; j < 1024; j++) {
                if (temp[j] != 0) {
                    for (int l = 0; l < 1024; l++) {
                        ndp[l ^ j] = Math.min(ndp[l ^ j], dp[l] + all - temp[j]);
                    }
                }
            }
            dp = ndp;
        }
        return dp[0];
    }
}
