package minimum.white.tiles.after.covering.with.carpets;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumWhiteTilesAfterCoveringWithCarpets {
  public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
    int len = floor.length();
    int[][] dp = new int[len + 1][numCarpets + 1];
    int inf = (int) 1e8;
    for (int i = 0; i <= len; i++) {
      Arrays.fill(dp[i], -inf);
    }
    int[] sum = new int[len + 1];
    for (int i = 0; i < len; i++) {
      sum[i + 1] = sum[i] + floor.charAt(i) - '0';
    }

    for (int i = 0; i <= len; i++) {
      dp[i][0] = 0;
    }

    for (int j = 1; j <= numCarpets; j++) {
      int max = 0;
      for (int i = 1; i <= len; i++) {
        if (i < j * carpetLen) {
          dp[i][j] = sum[i];
        } else {
          max = Math.max(max, dp[i - carpetLen][j - 1] + sum[i] - sum[i - carpetLen]);
          dp[i][j] = max;
        }
      }
    }
    int res = 0;
    for (int i = 1; i <= len; i++) {
      res = Math.max(res, dp[i][numCarpets]);
    }
    return sum[len] - res;
  }
}
