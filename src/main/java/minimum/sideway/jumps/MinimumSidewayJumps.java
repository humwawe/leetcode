package minimum.sideway.jumps;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumSidewayJumps {
    public int minSideJumps(int[] obstacles) {
        int len = obstacles.length;
        int[][] dp = new int[len][3];
        int inf = (int) 1e8;
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], inf);
        }
        dp[0][1] = 0;
        dp[0][0] = 1;
        dp[0][2] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] != j + 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                    for (int k = 0; k < 3; k++) {
                        if (k == j) {
                            continue;
                        }
                        if (obstacles[i] != k + 1) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + 1);
                        }
                    }
                }
            }
        }
        int res = inf;
        for (int i = 0; i < 3; i++) {
            res = Math.min(res, dp[len - 1][i]);
        }
        return res;
    }
}
