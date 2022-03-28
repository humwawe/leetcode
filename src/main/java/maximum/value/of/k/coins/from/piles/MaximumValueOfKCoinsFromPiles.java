package maximum.value.of.k.coins.from.piles;

import java.util.List;

/**
 * @author hum
 */
public class MaximumValueOfKCoinsFromPiles {
  public int maxValueOfCoins(List<List<Integer>> piles, int k) {
    int n = piles.size();
    int[][] dp = new int[n + 1][k + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        dp[i][j] = dp[i - 1][j];
        int sum = 0;
        for (int m = 0; m < piles.get(i - 1).size(); m++) {
          sum += piles.get(i - 1).get(m);
          if (j >= m + 1) {
            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - (m + 1)] + sum);
          }
        }
      }
    }
    return dp[n][k];
  }
}