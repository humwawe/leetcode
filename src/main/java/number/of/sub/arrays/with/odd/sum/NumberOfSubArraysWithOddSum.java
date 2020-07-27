package number.of.sub.arrays.with.odd.sum;

/**
 * @author hum
 */
public class NumberOfSubArraysWithOddSum {
    public int numOfSubarrays(int[] arr) {
        int len = arr.length;
        int mod = (int) (1e9 + 7);
        int[] cnt = new int[2];
        int sum = 0;
        cnt[0]++;
        long res = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            if (sum % 2 == 0) {
                res += cnt[1];
                cnt[0]++;
            } else {
                res += cnt[0];
                cnt[1]++;
            }
            res = res % mod;
        }
        return (int) res;
    }
}
