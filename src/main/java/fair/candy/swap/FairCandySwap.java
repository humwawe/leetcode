package fair.candy.swap;

import java.util.Arrays;

/**
 * @author hum
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        for (int i : b) {
            sum -= i;
        }
        sum /= 2;
        for (int i : a) {
            if (Arrays.binarySearch(b, i - sum) >= 0) {
                return new int[]{i, i - sum};
            }
        }
        return new int[]{};
    }
}
