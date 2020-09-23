package maximum.sum.obtained.of.any.permutation;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumSumObtainedOfAnyPermutation {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int len = nums.length;
        long[] cnt = new long[len + 1];
        for (int[] request : requests) {
            cnt[request[0]]++;
            cnt[request[1] + 1]--;
        }
        for (int i = 0; i < len - 1; i++) {
            cnt[i + 1] += cnt[i];
        }
        long res = 0;
        int mod = (int) (1e9 + 7);
        Arrays.sort(nums);
        Arrays.sort(cnt, 0, len);
        for (int i = len - 1; i >= 0; i--) {
            res += cnt[i] * nums[i];
            res %= mod;
        }
        return (int) (res % mod);
    }
}
