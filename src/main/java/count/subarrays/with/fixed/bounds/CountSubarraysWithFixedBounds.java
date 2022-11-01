package count.subarrays.with.fixed.bounds;

/**
 * @author hum
 */
public class CountSubarraysWithFixedBounds {
  public long countSubarrays(int[] nums, int minK, int maxK) {
    long res = 0L;
    int n = nums.length, minI = -1, maxI = -1, i0 = -1;
    for (var i = 0; i < n; ++i) {
      int x = nums[i];
      if (x == minK) {
        minI = i;
      }
      if (x == maxK) {
        maxI = i;
      }
      if (x < minK || x > maxK) {
        i0 = i;
      }
      res += Math.max(Math.min(minI, maxI) - i0, 0);
    }
    return res;
  }

}
