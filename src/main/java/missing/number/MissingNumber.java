package missing.number;

/**
 * @author hum
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int result = 0;
        for (int i = 0; i <= len; i++) {
            result ^= i;
        }
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
