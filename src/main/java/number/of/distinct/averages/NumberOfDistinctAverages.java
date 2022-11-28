package number.of.distinct.averages;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class NumberOfDistinctAverages {
  public int distinctAverages(int[] nums) {
    Arrays.sort(nums);
    Set<Integer> set = new HashSet<>();
    int n = nums.length;
    for (int i = 0, j = n - 1; i < j; i++, j--) {
      set.add(nums[i] + nums[j]);
    }
    return set.size();

  }

}
