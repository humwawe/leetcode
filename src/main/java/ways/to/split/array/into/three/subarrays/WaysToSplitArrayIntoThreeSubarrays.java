package ways.to.split.array.into.three.subarrays;

/**
 * @author hum
 */
public class WaysToSplitArrayIntoThreeSubarrays {
    public int waysToSplit(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        long res = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < len - 2; i++) {
            int left = sum[i + 1];
            int l = i + 1;
            int r = len - 2;
            while (l < r) {
                int mid = l + r >> 1;
                int v = sum[mid + 1] - sum[i + 1];
                if (v >= left) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int i1 = l;
            l = i + 1;
            r = len - 2;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                int lv = sum[mid + 1] - sum[i + 1];
                int rv = sum[len] - sum[mid + 1];
                if (lv <= rv) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int i2 = l;
            if (i1 <= i2) {
                if (i1 == i2) {
                    if (left <= sum[i1 + 1] - sum[i + 1] && sum[i1 + 1] - sum[i + 1] <= sum[len] - sum[i1 + 1]) {
                        res += 1;
                        res %= mod;
                    }
                } else {
                    res += i2 - i1 + 1;
                    res %= mod;
                }
            }
        }
        return (int) (res % mod);
    }
}
