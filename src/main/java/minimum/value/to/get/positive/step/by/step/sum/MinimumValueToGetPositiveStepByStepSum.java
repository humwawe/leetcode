package minimum.value.to.get.positive.step.by.step.sum;

/**
 * @author hum
 */
public class MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum < min) {
                min = sum;
            }
        }
        return 1 - min;
    }
}
