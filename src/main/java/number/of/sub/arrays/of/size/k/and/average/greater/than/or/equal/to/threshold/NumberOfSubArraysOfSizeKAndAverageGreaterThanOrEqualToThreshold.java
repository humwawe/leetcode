package number.of.sub.arrays.of.size.k.and.average.greater.than.or.equal.to.threshold;

/**
 * @author hum
 */
public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int t = k * threshold;
        int len = arr.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        int result = 0;
        for (int i = k; i <= len; i++) {
            if (sum[i] - sum[i - k] >= t) {
                result++;
            }
        }
        return result;
    }
}
