package largest.positive.integer.that.exists.with.its.negative;

/**
 * @author hum
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {
  public int findMaxK(int[] nums) {
    for (int i = 1000; i >= 1; i--) {
      int ok = 0;
      for (int v : nums) {
        if (v == i) {
          ok |= 1;
        }
        if (v == -i) {
          ok |= 2;
        }
      }
      if (ok == 3) {
        return i;
      }
    }
    return -1;
  }
}
