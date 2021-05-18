package sum.of.all.subset.xor.totals;

/**
 * @author hum
 */
public class SumOfAllSubsetXorTotals {
    public int subsetXORSum(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < 1 << len; i++) {
            int tmp = 0;
            for (int j = 0; j < len; j++) {
                if (((i >> j) & 1) == 1) {
                    tmp ^= nums[j];
                }
            }
            res += tmp;
        }
        return res;
    }
}
