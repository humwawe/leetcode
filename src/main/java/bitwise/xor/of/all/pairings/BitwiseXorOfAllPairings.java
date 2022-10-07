package bitwise.xor.of.all.pairings;

/**
 * @author hum
 */
public class BitwiseXorOfAllPairings {
  public int xorAllNums(int[] nums1, int[] nums2) {
    int res = 0, len1 = nums1.length, len2 = nums2.length;
    if (len2 % 2 != 0) {
      for (int i : nums1) {
        res = res ^ i;
      }
    }
    if (len1 % 2 != 0) {
      for (int i : nums2) {
        res = res ^ i;
      }
    }
    return res;
  }
}
