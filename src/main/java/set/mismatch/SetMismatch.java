package set.mismatch;

/**
 * @author hum
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] n = new int[nums.length + 1];
        for (int num : nums) {
            n[num] += 1;
        }
        int[] result = new int[2];
        for (int i = 1; i < n.length; i++) {
            if (n[i] == 2) {
                result[0] = i;
            }
            if (n[i] == 0) {
                result[1] = i;
            }
        }
        return result;
    }
}
