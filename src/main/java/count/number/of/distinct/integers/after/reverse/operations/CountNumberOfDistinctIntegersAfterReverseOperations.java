package count.number.of.distinct.integers.after.reverse.operations;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class CountNumberOfDistinctIntegersAfterReverseOperations {
  public int countDistinctIntegers(int[] nums) {
    Set<Integer> h = new HashSet<>();
    for (int v : nums) {
      h.add(v);
    }
    for (int v : nums) {
      int u = 0;
      while (v > 0) {
        u = u * 10 + v % 10;
        v /= 10;
      }
      h.add(u);
    }
    return h.size();
  }
}
