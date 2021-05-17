package maximum.distance.between.a.pair.of.values;

/**
 * @author hum
 */
public class MaximumDistanceBetweenAPairOfValues {
    public int maxDistance(int[] nums1, int[] nums2) {
        int j = 0;
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            while (j < nums2.length && nums2[j] >= nums1[i]) {
                j++;
            }
            if (i <= j) {
                res = Math.max(res, j - i - 1);
            }
        }
        return res;
    }
}
