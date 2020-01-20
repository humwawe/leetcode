package global.and.local.inversions;

/**
 * @author hum
 */
public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] a) {
        int max = 0;
        for (int i = 2; i < a.length; i++) {
            max = Math.max(max, a[i - 2]);
            if (a[i] < max) {
                return false;
            }
        }
        return true;
    }
}
