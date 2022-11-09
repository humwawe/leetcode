package maximum.sum.of.distinct.subarrays.with.length.k;

/**
 * @author hum
 */
public class MaximumSumOfDistinctSubarraysWithLengthK {
  public long maximumSubarraySum(int[] nums, int k) {
    int[] cnt = new int[100001];
    long ans = 0;
    int dup = 0;
    long s = 0;
    int n = nums.length;
    for (int i = 0; i < k - 1; i++) {
      s += nums[i];
      if (++cnt[nums[i]] == 2) {
        dup++;
      }
    }
    for (int i = k - 1; i < n; i++) {
      s += nums[i];
      if (++cnt[nums[i]] == 2) {
        dup++;
      }
      if (dup == 0) {
        ans = Math.max(ans, s);
      }
      s -= nums[i - (k - 1)];
      if (--cnt[nums[i - (k - 1)]] == 1) {
        dup--;
      }
    }
    return ans;
  }
}
