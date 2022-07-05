package number.of.people.aware.of.a.secret;

/**
 * @author hum
 */
public class NumberOfPeopleAwareOfASecret {
  public int peopleAwareOfSecret(int n, int delay, int forget) {
    int mod = (int) (1e9 + 7);
    long[] dp = new long[n + 1];
    dp[1] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = i + delay; j <= n && j < i + forget; j++) {
        dp[j] += dp[i];
        dp[j] %= mod;
      }
    }
    long res = 0;
    for (int i = n - forget + 1; i <= n; i++) {
      res += dp[i];
      res %= mod;
    }
    return (int) (res % mod);
  }
}
