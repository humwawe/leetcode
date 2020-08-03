package get.the.maximum.score;

/**
 * @author hum
 */
public class GetTheMaximumScore {
    public int maxSum(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0;
        int j = 0;
        long sum1 = 0;
        long sum2 = 0;
        long result = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j];
                j++;
            } else {
                result += Math.max(sum1, sum2) + nums1[i];
                i++;
                j++;
                sum1 = 0;
                sum2 = 0;
            }
        }
        while (i < len1) {
            sum1 += nums1[i++];
        }
        while (j < len2) {
            sum2 += nums2[j++];
        }
        result += Math.max(sum1, sum2);
        int mod = (int) 1e9 + 7;
        return (int) (result % mod);
    }
}
