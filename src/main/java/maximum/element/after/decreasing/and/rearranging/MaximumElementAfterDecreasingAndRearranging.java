package maximum.element.after.decreasing.and.rearranging;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumElementAfterDecreasingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            tmp = Math.min(tmp + 1, arr[i]);
        }
        return tmp;
    }
}
