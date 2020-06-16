package find.n.unique.integers.sum.up.to.zero;

/**
 * @author hum
 */
public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int v = 1;
        for (int i = 0; i < n / 2; i++) {
            result[i] = v;
            result[n - i - 1] = -v;
            v++;
        }
        return result;
    }
}
