package smallest.range.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class SmallestRangeII {
    public int smallestRangeII(int[] a, int k) {
        Arrays.sort(a);
        int len = a.length;
        int result = a[len - 1] - a[0];
        for (int i = 1; i < len; i++) {
            int min = Math.min(a[0] + k, a[i] - k);
            int max = Math.max(a[len - 1] - k, a[i - 1] + k);
            result = Math.min(max - min, result);
        }
        return result;
    }
}
