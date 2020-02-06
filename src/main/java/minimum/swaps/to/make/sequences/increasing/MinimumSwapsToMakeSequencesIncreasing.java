package minimum.swaps.to.make.sequences.increasing;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] a, int[] b) {
        int len = a.length;
        int[][] dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            if (a[i] > a[i - 1] && b[i] > b[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + 1);
            }
            if (a[i] > b[i - 1] && b[i] > a[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }
        return Math.min(dp[len - 1][0], dp[len - 1][1]);
    }
}
