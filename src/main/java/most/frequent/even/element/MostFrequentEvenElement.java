package most.frequent.even.element;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MostFrequentEvenElement {
  public int mostFrequentEven(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = -1;
    for (int num : nums) {
      if (num % 2 == 0) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        max = Math.max(max, map.get(num));
      }
    }
    if (max == -1) {
      return -1;
    }
    int res = (int) 1e8;
    for (Integer integer : map.keySet()) {
      if (map.get(integer) == max) {
        res = Math.min(res, integer);
      }
    }
    return res;
  }
}
