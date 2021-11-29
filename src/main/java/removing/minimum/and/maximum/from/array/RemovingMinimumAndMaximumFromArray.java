package removing.minimum.and.maximum.from.array;

/**
 * @author hum
 */
public class RemovingMinimumAndMaximumFromArray {
    public int minimumDeletions(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int max = nums[0];
        int maxIdx = 0;
        int min = nums[0];
        int minIdx = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }

        int i = Math.min(maxIdx, minIdx);
        int j = Math.max(maxIdx, minIdx);

        int res = i + 1 + len - j;
        res = Math.min(res, j + 1);
        res = Math.min(res, len - i);
        return res;
    }
}
