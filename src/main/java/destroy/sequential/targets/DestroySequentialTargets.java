package destroy.sequential.targets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class DestroySequentialTargets {
  public int destroyTargets(int[] nums, int space) {
    int n = nums.length;
    Arrays.sort(nums);
    Map<Integer, Integer> map = new HashMap<>();
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      b[i] = nums[i];
      nums[i] %= space;
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    int v = 0;
    for (Integer value : map.values()) {
      v = Math.max(v, value);
    }
    for (int i = 0; i < n; i++) {
      if (map.get(nums[i]) == v) {
        return b[i];
      }
    }
    return 0;

  }
}
