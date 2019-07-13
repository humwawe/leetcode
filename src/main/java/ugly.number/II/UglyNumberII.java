package ugly.number.II;

/**
 * @author hum
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;

        for (int i = 1; i < n; i++) {
            int min = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
            result[i] = min;
            if (min == result[p2] * 2) {
                p2++;
            }
            if (min == result[p3] * 3) {
                p3++;
            }
            if (min == result[p5] * 5) {
                p5++;
            }
        }

        return result[n - 1];
    }
}
