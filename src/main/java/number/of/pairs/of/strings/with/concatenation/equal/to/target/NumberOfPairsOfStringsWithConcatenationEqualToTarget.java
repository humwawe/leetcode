package number.of.pairs.of.strings.with.concatenation.equal.to.target;

/**
 * @author hum
 */
public class NumberOfPairsOfStringsWithConcatenationEqualToTarget {
    public int numOfPairs(String[] nums, String target) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (target.equals(nums[i] + nums[j])) {
                    res++;
                }
            }
        }
        return res;
    }
}
