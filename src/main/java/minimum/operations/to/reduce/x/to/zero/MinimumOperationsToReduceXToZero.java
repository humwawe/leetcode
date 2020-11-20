package minimum.operations.to.reduce.x.to.zero;

/**
 * @author hum
 */
public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum -= x;
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            while (curSum > sum && j <= i) {
                curSum -= nums[j++];
            }
            if (curSum == sum) {
                max = Math.max(max, i - j);
            }
        }
        return max == Integer.MIN_VALUE ? -1 : nums.length - max;
    }
}
