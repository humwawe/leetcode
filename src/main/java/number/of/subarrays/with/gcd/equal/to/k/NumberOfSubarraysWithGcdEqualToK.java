package number.of.subarrays.with.gcd.equal.to.k;

/**
 * @author hum
 */
public class NumberOfSubarraysWithGcdEqualToK {
  public int subarrayGCD(int[] nums, int k) {
    int n = nums.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] % k != 0) {
        continue;
      }
      int cur = 0;
      for (int j = i; j >= 0; j--) {
        cur = gcd(cur, nums[j]);
        if (cur == k) {
          res++;
        }
        if (cur < k) {
          break;
        }
      }
    }
    return res;
  }

  int gcd(int a, int b) {
    return a % b == 0 ? b : gcd(b, a % b);
  }
}
