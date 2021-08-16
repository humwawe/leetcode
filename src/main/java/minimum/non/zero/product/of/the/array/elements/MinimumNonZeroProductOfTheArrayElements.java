package minimum.non.zero.product.of.the.array.elements;

/**
 * @author hum
 */
public class MinimumNonZeroProductOfTheArrayElements {
    public int minNonZeroProduct(int p) {
        int mod = (int) (1e9 + 7);
        long cnt = (1L << (p - 1)) - 1;
        long l = (1L << p) - 2;
        long last = ((1L << p) - 1) % mod;
        int tmp = qp(l, cnt, mod);
        return (int) ((tmp * last) % mod);
    }

    int qp(long m, long k, int p) {
        long res = 1 % p, t = m;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = qm(res, t, p);
            }
            t = qm(t, t, p);
            k >>= 1;
        }
        return (int) res % p;
    }

    long qm(long a, long b, long p) {
        long ans = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans + a) % p;
            }
            a = (a << 1) % p;
            b = b >> 1;
        }
        return ans;
    }
}
