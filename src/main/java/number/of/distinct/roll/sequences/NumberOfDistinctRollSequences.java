package number.of.distinct.roll.sequences;

/**
 * @author hum
 */
public class NumberOfDistinctRollSequences {
  public int distinctSequences(int n) {
    int mod = 1000000007;
    if (n == 1) {
      return 6;
    }
    long[][] dp = new long[7][7];
    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j <= 6; j++) {
        if (gcd(i, j) == 1 && i != j) {
          dp[i][j] = 1;
        }
      }
    }
    for (int i = 3; i <= n; i++) {
      long[][] ndp = new long[7][7];
      for (int j = 1; j <= 6; j++) {
        for (int k = 1; k <= 6; k++) {
          for (int l = 1; l <= 6; l++) {
            if (gcd(k, l) == 1 && j != l && k != l) {
              ndp[k][l] += dp[j][k];
              ndp[k][l] %= mod;
            }
          }
        }
      }
      dp = ndp;
    }
    long res = 0;
    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j <= 6; j++) {
        res += dp[i][j];
      }
    }
    return (int) (res % mod);
  }

  public int gcd(int a, int b) {
    while (b > 0) {
      int c = a;
      a = b;
      b = c % b;
    }
    return a;
  }

}
