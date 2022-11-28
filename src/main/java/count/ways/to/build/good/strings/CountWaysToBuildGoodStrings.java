package count.ways.to.build.good.strings;

/**
 * @author hum
 */
public class CountWaysToBuildGoodStrings {
  public int countGoodStrings(int low, int high, int zero, int one) {
    int mod = (int) 1e9 + 7;
    int[] f = new int[high + 1];
    f[0] = 1;
    for (int i = 1; i <= high; i++) {
      int a = i >= zero ? f[i - zero] : 0, b = i >= one ? f[i - one] : 0;
      f[i] = (a + b) % mod;
    }
    int res = 0;
    for (int i = low; i <= high; i++) {
      res = (res + f[i]) % mod;
    }
    return res;
  }
}
