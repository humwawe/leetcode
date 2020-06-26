package shuffle.the.array;

/**
 * @author hum
 */
public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n << 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];
            result[index++] = nums[n + i];
        }
        return result;
    }
}
