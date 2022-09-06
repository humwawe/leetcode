package longest.nice.subarray;

/**
 * @author hum
 */
public class LongestNiceSubarray {
  public int longestNiceSubarray(int[] nums) {
    int res = 0;
    int x = 0;
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      while (j < i && (x & nums[i]) != 0) {
        x ^= nums[j];
        j++;
      }
      x |= nums[i];
      res = Math.max(res, i - j + 1);
    }
    return res;
  }
}
