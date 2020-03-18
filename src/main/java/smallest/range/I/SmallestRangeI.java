package smallest.range.I;

/**
 * @author hum
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] a, int k) {
        int min = 10000;
        int max = 0;
        for (int i : a) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        if (max - min <= 2 * k) {
            return 0;
        } else {
            return max - min - 2 * k;
        }
    }
}
