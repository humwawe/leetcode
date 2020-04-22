package minimum.number.of.k.consecutive.bit.flips;

/**
 * @author hum
 */
public class MinimumNumberOfKConsecutiveBitFlips {
    public int minKBitFlips(int[] a, int k) {
        int len = a.length;
        int[] mark = new int[len + 1];
        int result = 0;
        int op = 0;
        for (int i = 0; i <= len; i++) {
            op += mark[i];
            if ((a[i] == 0 && op % 2 == 0) || (a[i] == 1 && op % 2 == 1)) {
                op++;
                result++;
                if (i + k > len) {
                    return -1;
                }
                mark[i + k] -= 1;
            }
        }
        return result;
    }
}
