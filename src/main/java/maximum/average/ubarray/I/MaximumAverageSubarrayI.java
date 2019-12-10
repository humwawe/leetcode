package maximum.average.ubarray.I;

/**
 * @author hum
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double result;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            result = Math.max(result, sum / k);
        }
        return result;
    }
}
