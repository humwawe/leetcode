package monotonic.array;

/**
 * @author hum
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] a) {
        int len = a.length;
        boolean flag = true;
        for (int i = 0; i < len - 1; i++) {
            if (a[i] > a[i + 1]) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            for (int i = 0; i < len - 1; i++) {
                if (a[i] < a[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
