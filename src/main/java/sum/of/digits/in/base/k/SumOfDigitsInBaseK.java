package sum.of.digits.in.base.k;

/**
 * @author hum
 */
public class SumOfDigitsInBaseK {
    public int sumBase(int n, int k) {
        int res = 0;
        while (n > 0) {
            res += n % k;
            n /= k;
        }
        return res;
    }
}
