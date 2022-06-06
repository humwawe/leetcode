package partition.array.such.that.maximum.difference.is.k;

import java.util.Arrays;

/**
 * @author hum
 */
public class PartitionArraySuchThatMaximumDifferenceIsK {
  public int partitionArray(int[] nums, int k) {
    Arrays.sort(nums);
    int len = nums.length;
    int res = 0;
    for (int i = 0; i < len; i++) {
      int j = i;
      while (j + 1 < len && nums[j + 1] - nums[i] <= k) {
        j++;
      }
      i = j;
      res++;
    }
    return res;
  }
}
