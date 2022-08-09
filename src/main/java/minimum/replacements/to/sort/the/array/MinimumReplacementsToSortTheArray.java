package minimum.replacements.to.sort.the.array;

/**
 * @author hum
 */
public class MinimumReplacementsToSortTheArray {
  public long minimumReplacement(int[] nums) {
    int len = nums.length;
    int cur = nums[len - 1];
    long res = 0;
    for (int i = len - 2; i >= 0; i--) {
      if (nums[i] <= cur) {
        cur = nums[i];
        continue;
      }
      int x = (nums[i] - 1) / cur;
      res += x;
      cur = nums[i] / (x + 1);

    }

    return res;
  }
}
