package wiggle.sort.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        int[] clone = nums.clone();

        Arrays.sort(clone);
        int h = len;
        int l = (h + 1) / 2;
        for (int i = 0; i < len; i++) {
            nums[i] = (i & 1) == 0 ? clone[--l] : clone[--h];
        }
    }
}
