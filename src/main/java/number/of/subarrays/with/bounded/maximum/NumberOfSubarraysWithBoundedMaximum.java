package number.of.subarrays.with.bounded.maximum;

/**
 * @author hum
 */
public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] arr, int l, int r) {
        return helper(arr, r) - helper(arr, l - 1);
    }

    private int helper(int[] arr, int max) {
        int res = 0;
        int numSubarry = 0;
        for (int num : arr) {
            if (num <= max) {
                numSubarry++;
                res += numSubarry;
            } else {
                numSubarry = 0;
            }
        }
        return res;
    }
}
