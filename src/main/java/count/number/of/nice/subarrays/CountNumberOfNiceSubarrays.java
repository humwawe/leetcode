package count.number.of.nice.subarrays;

/**
 * @author hum
 */
public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int len = nums.length;
        int t[] = new int[len];
        int sum = 0;
        for (int num : nums) {
            sum += num % 2;
            t[sum]++;
            if (sum >= k) {
                result += t[sum - k];
            }
        }
        return result;
    }
}
