package intersection.of.multiple.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class IntersectionOfMultipleArrays {
  public List<Integer> intersection(int[][] nums) {
    int[] cnt = new int[1005];
    for (int[] num : nums) {
      for (int i : num) {
        cnt[i]++;
      }
    }
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < 1005; i++) {
      if (cnt[i] == nums.length) {
        res.add(i);
      }
    }
    return res;
  }

}
