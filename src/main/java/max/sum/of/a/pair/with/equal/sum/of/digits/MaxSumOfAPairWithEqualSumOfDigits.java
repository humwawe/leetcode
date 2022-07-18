package max.sum.of.a.pair.with.equal.sum.of.digits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class MaxSumOfAPairWithEqualSumOfDigits {
  public int maximumSum(int[] nums) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int num : nums) {
      int x = 0;
      int t = num;
      while (num > 0) {
        x += num % 10;
        num /= 10;
      }
      map.computeIfAbsent(x, e -> new ArrayList<>()).add(t);
    }
    int res = -1;
    for (Integer integer : map.keySet()) {
      List<Integer> list = map.get(integer);
      if (list.size() <= 1) {
        continue;
      }
      list.sort((x, y) -> y - x);
      res = Math.max(res, list.get(0) + list.get(1));
    }
    return res;
  }
}
