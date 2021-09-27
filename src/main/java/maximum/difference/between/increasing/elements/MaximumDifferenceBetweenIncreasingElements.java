package maximum.difference.between.increasing.elements;

/**
 * @author hum
 */
public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int len = nums.length;
        int res = -1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    res = Math.max(res, nums[j] - nums[i]);
                }
            }
        }
        return res;
    }
}
