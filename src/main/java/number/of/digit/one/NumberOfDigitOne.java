package number.of.digit.one;

/**
 * @author hum
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int result = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m, b = n % m;
            result += (a + 8) / 10 * m;
            if (a % 10 == 1) {
                result += b + 1;
            }
        }
        return result;
    }
}
