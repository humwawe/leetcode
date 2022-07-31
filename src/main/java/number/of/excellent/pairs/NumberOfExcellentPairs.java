package number.of.excellent.pairs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class NumberOfExcellentPairs {
  public long countExcellentPairs(int[] nums, int k) {
    Set<Integer> vis = new HashSet<>();
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int x : nums) {
      if (vis.add(x)) {
        int c = Integer.bitCount(x);
        cnt.put(c, cnt.getOrDefault(c, 0) + 1);
      }
    }
    long ans = 0L;
    for (Map.Entry<Integer, Integer> x : cnt.entrySet()) {
      for (Map.Entry<Integer, Integer> y : cnt.entrySet()) {
        if (x.getKey() + y.getKey() >= k) {
          ans += (long) x.getValue() * y.getValue();
        }
      }
    }
    return ans;
  }

}
