package max.dot.product.of.two.subsequences;

/**
 * @author hum
 */
public class MaxDotProductOfTwoSubsequences {
    Integer[][][] memo = new Integer[505][505][2];

    public int maxDotProduct(int[] nums1, int[] nums2) {
        return helper(nums1, 0, nums2, 0, 0);
    }

    private int helper(int[] nums1, int i, int[] nums2, int j, int f) {
        if (i == nums1.length || j == nums2.length) {
            if (f == 1) {
                return 0;
            } else {
                return -0x3f3f3f3f;
            }
        }
        if (memo[i][j][f] != null) {
            return memo[i][j][f];
        }
        int tmp = nums1[i] * nums2[j] + helper(nums1, i + 1, nums2, j + 1, 1);
        int tmp1 = Math.max(helper(nums1, i + 1, nums2, j, f), helper(nums1, i, nums2, j + 1, f));
        return memo[i][j][f] = Math.max(tmp, tmp1);
    }
}
