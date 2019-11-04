package max.consecutive.ones;

/**
 * @author hum
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int len = 0;
        for (int num : nums) {
            if (num == 1) {
                len++;
            } else {
                result = Math.max(len, result);
                len = 0;
            }
        }
        return Math.max(len, result);
    }
}
