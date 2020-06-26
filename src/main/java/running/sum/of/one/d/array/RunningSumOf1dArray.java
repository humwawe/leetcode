package running.sum.of.one.d.array;

/**
 * @author hum
 */
public class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        result[0] = nums[0];
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}
