package append.k.integers.with.minimal.sum;

import java.util.Arrays;

/**
 * @author hum
 */
public class AppendKIntegersWithMinimalSum {
  int len;

  public long minimalKSum(int[] nums, int k) {
    long res = 0;
    len = 0;
    discrete(nums);
    for (int i = 0; i < len; i++) {
      int num = nums[i];
      if (num <= k) {
        res += num;
        k++;
      }
    }
    return (long) k * (k + 1) / 2 - res;
  }

  void discrete(int[] a) {
    Arrays.sort(a);
    for (int i = 0; i < a.length; i++) {
      if (i == 0 || a[i] != a[i - 1]) {
        a[len++] = a[i];
      }
    }
  }
}
