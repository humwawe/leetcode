package minimum.deletions.to.make.array.divisible;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumDeletionsToMakeArrayDivisible {
  public int minOperations(int[] nums, int[] numsDivide) {
    int x = 0;
    for (int i : numsDivide) {
      x = gcd(x, i);
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (x % nums[i] == 0) {
        return i;
      }
    }
    return -1;

  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
