package maximum.sum.circular.subarray;

/**
 * @author hum
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] a) {
        int prev = a[0];
        int max = a[0];
        int sum = a[0];
        for (int i = 1; i < a.length; i++) {
            sum += a[i];
            if (prev < 0) {
                prev = a[i];
            } else {
                prev = prev + a[i];
            }
            max = Math.max(max, prev);
        }
        int min = 0;
        prev = 0;
        for (int i = 1; i < a.length - 1; i++) {
            if (prev > 0) {
                prev = a[i];
            } else {
                prev += a[i];
            }
            min = Math.min(min, prev);
        }
        return Math.max(max, sum - min);
    }
}
