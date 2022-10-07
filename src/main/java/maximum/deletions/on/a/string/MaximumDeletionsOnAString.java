package maximum.deletions.on.a.string;

/**
 * @author hum
 */
public class MaximumDeletionsOnAString {
  public int deleteString(String s) {
    int n = s.length();
    hash(s);

    int[] dp = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      dp[i] = 1;
      for (int mid = i; mid + 1 + mid - i < n; mid++) {
        int j = mid + 1;
        int r = j + mid - i;
        if (get(i + 1, mid + 1) == get(j + 1, r + 1)) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    return dp[0];

  }

  long P = 133331;
  int N = 4050;
  long[] h = new long[N];
  long[] p = new long[N];
  long mod = (1L << 61) - 1;

  public void hash(String str) {
    // 初始化
    p[0] = 1;
    for (int i = 1; i <= str.length(); i++) {
      h[i] = mul(h[i - 1], P) + str.charAt(i - 1);
      if (h[i] >= mod) {
        h[i] -= mod;
      }
      p[i] = mul(p[i - 1], P);
    }
  }

  // 计算子串 str[l ~ r] 的哈希值，下标从1开始
  long get(int l, int r) {
    return modular(h[r] - mul(h[l - 1], p[r - l + 1]));
  }

  // 仅对mod = (1L << 61) - 1 有效，hash重复率较低
  private long mul(long a, long b) {
    long al = a & (1L << 31) - 1, ah = a >>> 31;
    long bl = b & (1L << 31) - 1, bh = b >>> 31;
    // <2^62
    long low = al * bl;
    // < 2^62
    long mid = al * bh + bl * ah;
    // < 2^60 + 2^31 < 2^61
    long high = ah * bh + (mid >>> 31);
    // high*2^62 = high*2 (mod 2^61-1)
    return modular(modular(2 * high + low) + ((mid & (1L << 31) - 1) << 31));
  }

  private long modular(long a) {
    while (a >= mod) {
      a -= mod;
    }
    while (a < 0) {
      a += mod;
    }
    return a;
  }
}
