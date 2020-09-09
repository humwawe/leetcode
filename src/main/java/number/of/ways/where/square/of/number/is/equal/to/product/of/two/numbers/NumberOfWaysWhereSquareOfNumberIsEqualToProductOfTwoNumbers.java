package number.of.ways.where.square.of.number.is.equal.to.product.of.two.numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {
    public int numTriplets(int[] nums1, int[] nums2) {
        return helper(nums1, nums2) + helper(nums2, nums1);
    }

    private int helper(int[] nums1, int[] nums2) {
        int len = nums1.length;
        Map<Long, Integer> map = new HashMap<>();
        for (int value : nums1) {
            map.put((long) value * value, map.getOrDefault((long) value * value, 0) + 1);
        }
        int res = 0;
        int len2 = nums2.length;
        for (int i = 0; i < len2; i++) {
            for (int j = i + 1; j < len2; j++) {
                long tmp = (long) nums2[i] * nums2[j];
                if (map.containsKey(tmp)) {
                    res += map.get(tmp);
                }
            }
        }
        return res;
    }
}
