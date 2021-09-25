package count.number.of.pairs.with.absolute.difference.k;

/**
 * @author hum
 */
public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
