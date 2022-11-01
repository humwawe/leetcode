package minimum.addition.to.make.integer.beautiful;

/**
 * @author hum
 */
public class MinimumAdditionToMakeIntegerBeautiful {
  public int getSum(long n) {
    int sum = 0;
    while (n > 0) {
      sum += n % 10;
      n /= 10;
    }
    return sum;
  }

  public long makeIntegerBeautiful(long n, int target) {
    if (getSum(n) <= target) {
      return 0;
    }
    long mod = 10L, res = 0L;
    while (getSum(n) > target) {
      long t = mod - n % mod;
      res += t;
      n += t;
      mod *= 10;
    }

    return res;

  }
}
