package arithmetic.slices;

/**
 * @author hum
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] a) {
        if (a.length < 3) {
            return 0;
        }
        int[] b = new int[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            b[i - 1] = a[i] - a[i - 1];
        }

        int result = 0;
        for (int i = 0; i < b.length; ) {
            int j = i + 1;
            while (j < b.length) {
                if (b[j] == b[i]) {
                    j++;
                } else {
                    break;
                }
            }
            int len = j - i - 1;
            result += len * (len + 1) / 2;
            i = j;
        }
        return result;
    }
}
