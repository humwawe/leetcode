package count.number.of.bad.pairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class CountNumberOfBadPairs {
  public long countBadPairs(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int len = nums.length;
    long res = (long) len * (len - 1) / 2;
    for (int i = 0; i < len; i++) {
      int x = nums[i] - i;
      res -= map.getOrDefault(x, 0);
      map.put(x, map.getOrDefault(x, 0) + 1);
    }
    return res;
  }
}
