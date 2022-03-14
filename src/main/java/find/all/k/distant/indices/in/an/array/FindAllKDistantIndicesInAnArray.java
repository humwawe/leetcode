package find.all.k.distant.indices.in.an.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FindAllKDistantIndicesInAnArray {
  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    List<Integer> res = new ArrayList<>();
    int len = nums.length;
    int slow = 0;
    for (int fast = 0; fast < len; fast++) {
      if (nums[fast] == key) {
        slow = Math.max(slow, fast - k);
        int end = Math.min(fast + k, len - 1);
        while (slow <= end) {
          res.add(slow++);
        }
      }
    }
    return res;
  }

}
