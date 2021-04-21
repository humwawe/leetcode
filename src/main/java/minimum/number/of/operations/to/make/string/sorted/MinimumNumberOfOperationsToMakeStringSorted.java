package minimum.number.of.operations.to.make.string.sorted;

/**
 * @author hum
 */
public class MinimumNumberOfOperationsToMakeStringSorted {
    int mod = (int) (1e9 + 7);
    int N = 3010;
    long[] f = new long[N];
    long[] g = new long[N];

    public int makeStringSorted(String s) {
        int[] cnt = new int[26];
        int len = s.length();

        cnt[s.charAt(0) - 'a']++;
        f[0] = 1;
        g[0] = 1;
        for (int i = 1; i < len; i++) {
            cnt[s.charAt(i) - 'a']++;
            f[i] = f[i - 1] * i % mod;
            g[i] = qp(f[i], mod - 2, mod);
        }
        long res = 0;
        for (char c : s.toCharArray()) {
            int x = c - 'a';
            for (int i = 0; i < x; i++) {
                if (cnt[i] == 0) {
                    continue;
                }
                cnt[i]--;
                res = (res + helper(cnt)) % mod;
                cnt[i]++;
            }
            cnt[x]--;
        }
        return (int) (res % mod);
    }

    private long helper(int[] cnt) {
        int s = 0;
        for (int i = 0; i < 26; i++) {
            s += cnt[i];
        }
        long res = f[s];
        for (int i = 0; i < 26; i++) {
            res = res * g[cnt[i]] % mod;
        }
        return res;
    }

    long qp(long m, int k, int p) {
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
