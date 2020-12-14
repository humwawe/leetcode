package sum.of.absolute.aifferences.in.a.sorted.array;

/**
 * @author hum
 */
public class SumOfAbsoluteDifferencesInASortedArray {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int left = sum[i];
            int right = sum[len] - sum[i + 1];
            res[i] = (i + 1) * nums[i] - left + right - (len - i) * nums[i];
        }
        return res;
    }
}
