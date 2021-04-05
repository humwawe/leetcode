package minimum.absolute.sum.difference;

import java.util.TreeSet;

/**
 * @author hum
 */
public class MinimumAbsoluteSumDifference {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long sum = 0;
        int len = nums1.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
            set.add(nums1[i]);
        }
        long res = sum;
        for (int i = 0; i < len; i++) {
            int tmp = Math.abs(nums1[i] - nums2[i]);
            Integer ceiling = set.ceiling(nums2[i]);
            if (ceiling != null) {
                res = Math.min(res, sum - tmp + Math.abs(ceiling - nums2[i]));
            }
            Integer floor = set.floor(nums2[i]);
            if (floor != null) {
                res = Math.min(res, sum - tmp + Math.abs(floor - nums2[i]));
            }
        }
        int mod = (int) (1e9 + 7);
        return (int) (res % mod);
    }
}
