package count.good.numbers;

/**
 * @author hum
 */
public class CountGoodNumbers {
    public int countGoodNumbers(long n) {
        if (n == 1) {
            return 5;
        }
        int mod = (int) (1e9 + 7);
        long j = n / 2;
        long o = n - n / 2;
        long res = 1;
        res = res * qp(4, j, mod) % mod;
        res = res * qp(5, o, mod) % mod;
        return (int) res % mod;
    }

    long qp(long m, long k, int p) {
        long res = 1 % p, t = m;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = res * t % p;
            }
            t = t * t % p;
            k >>= 1;
        }
        return res % p;
    }
}
