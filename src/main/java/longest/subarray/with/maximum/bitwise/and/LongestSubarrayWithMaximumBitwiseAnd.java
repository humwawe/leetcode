package longest.subarray.with.maximum.bitwise.and;

/**
 * @author hum
 */
public class LongestSubarrayWithMaximumBitwiseAnd {
  public int longestSubarray(int[] nums) {
    int max = 0;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    int cnt = 0;
    int res = 0;
    for (int num : nums) {
      if (num == max) {
        cnt++;
      } else {
        cnt = 0;
      }
      res = Math.max(res, cnt);
    }
    return res;
  }
}
