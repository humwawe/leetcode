package count.subarrays.with.score.less.than.k;

/**
 * @author hum
 */
public class CountSubarraysWithScoreLessThanK {
  public long countSubarrays(int[] nums, long k) {
    int n = nums.length;
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }
    long res = 0;
    int j = -1;
    for (int i = 0; i < n; i++) {
      while (j + 1 < n && (sum[j + 2] - sum[i]) * (j - i + 2) < k) {
        j++;
      }
      res += j - i + 1;
    }
    return res;
  }
}
