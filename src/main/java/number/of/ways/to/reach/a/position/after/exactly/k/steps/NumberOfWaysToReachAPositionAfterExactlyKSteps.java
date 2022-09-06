package number.of.ways.to.reach.a.position.after.exactly.k.steps;

/**
 * @author hum
 */
public class NumberOfWaysToReachAPositionAfterExactlyKSteps {
  int mod = (int) 1E9 + 7;

  public int numberOfWays(int startPos, int endPos, int k) {
    long[][] dp = new long[3005][1005];
    dp[startPos + 1 + 1000][1] = 1;
    dp[startPos - 1 + 1000][1] = 1;
    for (int i = 2; i <= k; i++) {
      for (int j = 1000 + startPos - i; j <= 1000 + startPos + i; j++) {
        dp[j][i] = dp[j - 1][i - 1] + dp[j + 1][i - 1];
        dp[j][i] %= mod;
      }
    }
    return (int) dp[1000 + endPos][k];
  }

}
