package most.frequent.number.following.key.in.an.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MostFrequentNumberFollowingKeyInAnArray {
  public int mostFrequent(int[] nums, int key) {
    int len = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < len - 1; i++) {
      if (nums[i] == key) {
        map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
      }
    }
    int max = 0;
    int res = 0;
    for (Integer k : map.keySet()) {
      if (map.get(k) > max) {
        max = map.get(k);
        res = k;
      }
    }
    return res;
  }
}
