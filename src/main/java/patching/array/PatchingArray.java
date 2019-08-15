package patching.array;

/**
 * @author hum
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long range = 0;
        int result = 0;
        int pos = 0;
        long i = 1;
        while (i <= n) {
            if (pos >= nums.length || i < nums[pos]) {
                result++;
                range += i;
            } else {
                range += nums[pos];
                pos++;
            }
            i = range + 1;
        }
        return result;
    }
}
