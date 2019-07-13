package single.number.III;

/**
 * @author hum
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        int index = 0;
        for (int i = 0; i < 31; i++) {
            if ((tmp & (1 << i)) == (1 << i)) {
                index = 1 << i;
                break;
            }
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & index) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }
}
