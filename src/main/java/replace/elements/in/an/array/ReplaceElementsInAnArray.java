package replace.elements.in.an.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class ReplaceElementsInAnArray {
  public int[] arrayChange(int[] nums, int[][] operations) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = operations.length - 1; i >= 0; i--) {
      map.put(operations[i][0], map.getOrDefault(operations[i][1], operations[i][1]));
    }
    int len = nums.length;
    int[] res = new int[len];
    for (int i = 0; i < len; i++) {
      res[i] = map.getOrDefault(nums[i], nums[i]);
    }
    return res;
  }
}
