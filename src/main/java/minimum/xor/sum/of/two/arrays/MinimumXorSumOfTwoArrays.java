package minimum.xor.sum.of.two.arrays;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumXorSumOfTwoArrays {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] f = new int[1 << len];
        int inf = (int) 1e8;
        Arrays.fill(f, inf);
        f[0] = 0;
        for (int mask = 1; mask < (1 << len); ++mask) {
            for (int i = 0; i < len; ++i) {
                if ((mask & (1 << i)) != 0) {
                    f[mask] = Math.min(f[mask], f[mask ^ (1 << i)] + (nums1[Integer.bitCount(mask) - 1] ^ nums2[i]));
                }
            }
        }

        return f[(1 << len) - 1];
    }
}
