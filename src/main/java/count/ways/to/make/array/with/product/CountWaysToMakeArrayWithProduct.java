package count.ways.to.make.array.with.product;

/**
 * @author hum
 */
public class CountWaysToMakeArrayWithProduct {
    int N = 10005;
    int[] primes = new int[N];
    int cnt = 0;
    int mod = (int) (1e9 + 7);


    public int[] waysToFillArray(int[][] queries) {
        getPrimes(N);
        combination2();
        int[] res = new int[queries.length];
        for (int i = 0, queriesLength = queries.length; i < queriesLength; i++) {
            int n = queries[i][0];
            int k = queries[i][1];
            long tmp = 1;
            for (int j = 0; primes[j] <= k / primes[j]; j++) {
                int p = primes[j];
                if (k % p == 0) {
                    int s = 0;
                    while (k % p == 0) {
                        k /= p;
                        s++;
                    }
                    tmp *= comb(s + n - 1, n - 1);
                    tmp %= mod;
                }
            }
            if (k > 1) {
                tmp *= n;
                tmp %= mod;
            }
            res[i] = (int) (tmp % mod);
        }
        return res;
    }

    long[] fact = new long[N];
    long[] infact = new long[N];

    void combination2() {
        fact[0] = infact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = fact[i - 1] * i % mod;
            infact[i] = infact[i - 1] * qp(i, mod - 2, mod) % mod;
        }
    }

    long comb(int a, int b) {
        return (fact[a] * infact[b] % mod * infact[a - b] % mod);
    }

    void getPrimes(int n) {
        boolean[] st = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
    }

    int qp(int m, int k, int p) {
        long res = 1 % p, t = m;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = res * t % p;
            }
            t = t * t % p;
            k >>= 1;
        }
        return (int) res % p;
    }
}
