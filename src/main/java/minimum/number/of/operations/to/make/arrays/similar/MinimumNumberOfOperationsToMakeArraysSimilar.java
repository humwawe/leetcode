package minimum.number.of.operations.to.make.arrays.similar;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumNumberOfOperationsToMakeArraysSimilar {
  public long makeSimilar(int[] nums, int[] target) {
    f(nums);
    f(target);
    long res = 0L;
    for (var i = 0; i < nums.length; ++i) {
      res += Math.abs(nums[i] - target[i]);
    }
    return res / 4;
  }

  private void f(int[] a) {
    // 由于元素都是正数，把奇数变成相反数，这样排序后奇偶就自动分开了
    for (var i = 0; i < a.length; ++i) {
      if (a[i] % 2 != 0) {
        a[i] = -a[i];
      }
    }
    Arrays.sort(a);
  }
}
