package reverse.subarray.to.maximize.array.value;

/**
 * @author hum
 */
public class ReverseSubarrayToMaximizeArrayValue {
    public int maxValueAfterReverse(int[] nums) {
        int inf = (int) 1e9;
        int len = nums.length;
        int sum = 0;
        int result;
        for (int i = 1; i < len; ++i) {
            sum += Math.abs(nums[i - 1] - nums[i]);
        }
        result = sum;
        for (int i = 1; i < len - 1; ++i) {
            result = Math.max(result, sum - Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[i + 1] - nums[0]));
            result = Math.max(result, sum - Math.abs(nums[i] - nums[i - 1]) + Math.abs(nums[i - 1] - nums[len - 1]));
        }
        for (int f1 : new int[]{-1, 1}) {
            for (int f2 : new int[]{-1, 1}) {
                int maxF = -inf;
                int minG = inf;
                for (int i = 1; i < len; ++i) {
                    maxF = Math.max(maxF, f1 * nums[i - 1] + f2 * nums[i] - Math.abs(nums[i - 1] - nums[i]));
                    minG = Math.min(minG, f1 * nums[i - 1] + f2 * nums[i] + Math.abs(nums[i - 1] - nums[i]));
                }
                result = Math.max(result, sum + maxF - minG);
            }
        }
        return result;

    }
}
