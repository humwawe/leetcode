package maximum.candies.allocated.to.k.children;

/**
 * @author hum
 */
public class MaximumCandiesAllocatedToKChildren {
  int[] c;
  long k;

  public int maximumCandies(int[] candies, long k) {
    this.c = candies;
    this.k = k;
    long l = 0;
    long r = (long) 1e7;
    while (l < r) {
      long mid = l + r + 1 >> 1;
      if (check(mid)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return (int) l;

  }

  private boolean check(long mid) {
    long res = 0;
    for (int i : c) {
      res += i / mid;
    }
    return res >= k;
  }
}
