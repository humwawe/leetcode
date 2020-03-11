package sum.of.subsequence.widths;

import java.util.Arrays;

/**
 * @author hum
 */
public class SumOfSubsequenceWidths {
    public int sumSubseqWidths(int[] a) {
        int len = a.length;
        long[] pow = new long[len];
        Arrays.fill(pow, 1);
        int mod = (int) (1e9 + 7);
        for (int i = 1; i < len; i++) {
            pow[i] = pow[i - 1] * 2 % mod;
        }
        Arrays.sort(a);
        long result = 0;
        for (int i = 0; i < len; i++) {
            result -= a[i] * pow[len - 1 - i] % mod;
            result += a[i] * pow[i] % mod;
            result %= mod;
        }
        return (int) result;
    }
}
