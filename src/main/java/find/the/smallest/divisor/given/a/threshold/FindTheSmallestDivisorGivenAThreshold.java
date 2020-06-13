package find.the.smallest.divisor.given.a.threshold;

/**
 * @author hum
 */
public class FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = (int) 1e6;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (helper(nums, mid) <= threshold) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int helper(int[] nums, int mid) {
        int res = 0;
        for (int num : nums) {
            int t = num / mid;
            if (num % mid != 0) {
                t = t + 1;
            }
            res += t;
        }
        return res;
    }
}
