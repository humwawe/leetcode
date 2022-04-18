package maximum.total.beauty.of.the.gardens;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumTotalBeautyOfTheGardens {
  public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
    Arrays.sort(flowers);
    long n = flowers.length;
    if (target <= flowers[0]) {
      return full * n;
    }
    long leftFlowers = newFlowers - target * n;
    for (int i = 0; i < n; i++) {
      flowers[i] = Math.min(flowers[i], target);
      leftFlowers += flowers[i];
    }
    long ans = 0;
    long sumFlowers = 0;
    for (int i = 0, x = 0; i <= n; i++) {
      if (leftFlowers >= 0) {
        while (x < i && (long) flowers[x] * x - sumFlowers <= leftFlowers) {
          sumFlowers += flowers[x++];
        }
        long temp = (n - i) * full;
        if (x > 0) {
          temp += Math.min((sumFlowers + leftFlowers) / x, (long) target - 1) * partial;
        }
        ans = Math.max(ans, temp);
      }
      if (i < n) {
        leftFlowers += target - flowers[i];
      }
    }
    return ans;
  }
}
