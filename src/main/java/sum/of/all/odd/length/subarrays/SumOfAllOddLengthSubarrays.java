package sum.of.all.odd.length.subarrays;

/**
 * @author hum
 */
public class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }
        int res = 0;
        for (int l = 1; l <= len; l += 2) {
            for (int i = 0; i < len; i++) {
                int j = i + l;
                if (j > len) {
                    continue;
                }
                res += sum[j] - sum[i];
            }
        }
        return res;
    }
}
