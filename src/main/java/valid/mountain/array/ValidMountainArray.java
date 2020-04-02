package valid.mountain.array;

/**
 * @author hum
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] a) {
        int len = a.length;
        if (len < 3) {
            return false;
        }
        int i;
        for (i = 0; i < len - 1; ) {
            if (a[i] < a[i + 1]) {
                i++;
            } else {
                break;
            }
        }
        if (i == 0 || i == len - 1) {
            return false;
        }
        for (int j = i; j < len - 1; j++) {
            if (a[j] <= a[j + 1]) {
                return false;
            }
        }
        return true;
    }
}
