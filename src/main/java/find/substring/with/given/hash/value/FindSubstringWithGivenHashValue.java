package find.substring.with.given.hash.value;

/**
 * @author hum
 */
public class FindSubstringWithGivenHashValue {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int len = s.length();
        h = new long[len + 1];
        p = new long[len + 1];
        P = power;
        mod = modulo;
        String s1 = new StringBuilder(s).reverse().toString();
        hash(s1);
        int idx = 0;
        for (int i = 1; i + k - 1 <= len; i++) {
            int j = i + k - 1;
            if (get(i, j) == hashValue) {
                idx = i;
            }
        }
        return new StringBuilder(s1.substring(idx - 1, idx + k - 1)).reverse().toString();
    }

    long P;
    long[] h;
    long[] p;
    long mod;

    public void hash(String str) {
        p[0] = 1;
        for (int i = 1; i <= str.length(); i++) {
            h[i] = mul(h[i - 1], P) + (str.charAt(i - 1) - 'a' + 1);
            if (h[i] >= mod) {
                h[i] -= mod;
            }
            p[i] = mul(p[i - 1], P);
        }
    }

    long get(int l, int r) {
        return modular(h[r] - mul(h[l - 1], p[r - l + 1]));
    }

    private long mul(long a, long b) {
        return a * b % mod;

    }

    private long modular(long a) {
        while (a >= mod) {
            a -= mod;
        }
        while (a < 0) {
            a += mod;
        }
        return a;
    }
}
