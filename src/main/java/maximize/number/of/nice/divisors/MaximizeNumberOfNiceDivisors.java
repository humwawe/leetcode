package maximize.number.of.nice.divisors;

/**
 * @author hum
 */
public class MaximizeNumberOfNiceDivisors {
    int mod = (int) 1e9 + 7;

    private long qpow(int a, int k) {
        long ans = 1, p = a;
        while (k > 0) {
            if ((k & 1) > 0) {
                ans = ans * p % mod;
            }
            p = p * p % mod;
            k >>= 1;
        }
        return ans;
    }

    public int maxNiceDivisors(int m) {
        if (m <= 4) {
            return m;
        }
        int p = m / 3;
        int q = m % 3;
        if (q == 0) {
            return (int) qpow(3, p);
        }
        if (q == 1) {
            return (int) (qpow(3, p - 1) * 4 % mod);
        }
        return (int) (qpow(3, p) * 2 % mod);
    }
}
