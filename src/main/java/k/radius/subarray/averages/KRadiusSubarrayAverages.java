package k.radius.subarray.averages;

/**
 * @author hum
 */
public class KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        long[] sum = new long[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int y2 = i + k + 1;
            int y1 = i - k;
            if (y2 <= len && y1 >= 0) {
                res[i] = (int) ((sum[y2] - sum[y1]) / (2 * k + 1));
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
