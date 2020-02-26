package peak.index.in.a.mountain.array;

/**
 * @author hum
 */
public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            if (a[i] > a[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}
