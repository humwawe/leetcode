package k.concatenation.maximum.sum;

/**
 * @author hum
 */
public class KConcatenationMaximumSum {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int len = arr.length;
        long sum = 0;
        long result = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            result = Math.max(result, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        long l = 0;
        sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            l = Math.max(sum, l);
        }
        long r = 0;
        sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += arr[i];
            r = Math.max(sum, r);
        }
        result = Math.max(result, l);
        result = Math.max(result, r);
        if (k > 1) {
            result = Math.max(result, l + r);
            result = Math.max(result, sum * (k - 2) + l + r);
        }
        int mod = (int) (1e9 + 7);
        return (int) (result % mod);
    }
}
