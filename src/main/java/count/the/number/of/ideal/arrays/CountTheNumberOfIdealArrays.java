package count.the.number.of.ideal.arrays;

/**
 * @author hum
 */
public class CountTheNumberOfIdealArrays {
  public int idealArrays(int n, int maxValue) {
    long[][] dp = new long[15][maxValue + 1];


    for (int i = 1; i <= maxValue; i++) {
      dp[1][i] = 1;
    }

    int mod = (int) (1e9 + 7);
    for (int idx = 2; idx <= 14; idx++) {
      for (int i = 1; i <= maxValue; i++) {
        for (int j = i + i; j <= maxValue; j += i) {
          dp[idx][j] += dp[idx - 1][i];
          dp[idx][j] %= mod;
        }
      }
    }

    long[][] es = enumFAndIf(n, mod);


    long res = 0;
    for (int i = 1; i <= 14; i++) {
      for (int j = 1; j <= maxValue; j++) {
        res = (res + dp[i][j] * c(n - 1, i - 1, mod, es) % mod) % mod;
      }
    }
    return (int) res;
  }

  long[][] enumFAndIf(int n, int mod) {
    long[] f = new long[n + 1];
    long[] invf = new long[n + 1];
    f[0] = 1;
    for (int i = 1; i <= n; i++) {
      f[i] = f[i - 1] * i % mod;
    }
    invf[n] = invl(f[n], mod);
    for (int i = n - 1; i >= 0; i--) {
      invf[i] = invf[i + 1] * (i + 1) % mod;
    }
    return new long[][]{f, invf};
  }

  // a在mod下的逆元，mod可不为质数
  long invl(long a, long mod) {
    long b = mod;
    long p = 1, q = 0;
    while (b > 0) {
      long c = a / b;
      long d;
      d = a;
      a = b;
      b = d % b;
      d = p;
      p = q;
      q = d - c * q;
    }
    return p < 0 ? p + mod : p;
  }

  // 预处理 enumFAndIf 后求组合数
  long c(int a, int b, int mod, long[][] fif) {
    if (b < 0 || b > a) {
      return 0;
    }
    return fif[0][a] * fif[1][b] % mod * fif[1][a - b] % mod;
  }
}
