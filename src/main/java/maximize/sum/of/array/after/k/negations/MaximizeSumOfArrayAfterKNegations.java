package maximize.sum.of.array.after.k.negations;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] a, int k) {
        Arrays.sort(a);
        int sum = 0, len = a.length, i = 0;
        while (k > 0) {
            a[i] = -a[i];
            k--;
            if (i + 1 < len && a[i] > a[i + 1]) {
                i++;
            }
        }
        for (int num : a) {
            sum += num;
        }
        return sum;
    }
}
