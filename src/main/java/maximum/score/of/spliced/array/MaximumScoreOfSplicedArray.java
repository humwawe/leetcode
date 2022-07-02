package maximum.score.of.spliced.array;

/**
 * @author hum
 */
public class MaximumScoreOfSplicedArray {
  public int maximumsSplicedArray(int[] nums1, int[] nums2) {
    return Math.max(helper(nums1, nums2), helper(nums2, nums1));
  }

  int helper(int[] nums1, int[] nums2) {
    int s1 = 0, maxSum = 0;
    for (int i = 0, s = 0; i < nums1.length; ++i) {
      s1 += nums1[i];
      s = Math.max(s + nums2[i] - nums1[i], 0);
      maxSum = Math.max(maxSum, s);
    }
    return s1 + maxSum;
  }
}
