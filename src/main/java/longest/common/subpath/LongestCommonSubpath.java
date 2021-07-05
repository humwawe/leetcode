package longest.common.subpath;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class LongestCommonSubpath {
    int P = 133331;
    int N = (int) (1e5 + 10);
    long[] h = new long[N];
    long[] p = new long[N];
    long mod = (1L << 61) - 1;
    int[][] paths;

    public int longestCommonSubpath(int n, int[][] paths) {
        this.paths = paths;
        int l = 0, r = 100000;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int mid) {
        Set<Long> set = new HashSet<>();
        hash(paths[0]);
        for (int j = mid; j <= paths[0].length; j++) {
            long t = get(j - mid + 1, j);
            set.add(t);
        }
        for (int i = 1; i < paths.length; i++) {
            hash(paths[i]);
            Set<Long> newSet = new HashSet<>();
            for (int j = mid; j <= paths[i].length; j++) {
                long t = get(j - mid + 1, j);
                if (set.contains(t)) {
                    newSet.add(t);
                }
            }
            if (newSet.isEmpty()) {
                return false;
            }
            set = newSet;
        }
        return true;
    }

    public void hash(int[] str) {
        p[0] = 1;
        for (int i = 1; i <= str.length; i++) {
            h[i] = mul(h[i - 1], P) + str[i - 1];
            if (h[i] >= mod) {
                h[i] -= mod;
            }
            p[i] = mul(p[i - 1], P);
        }
    }

    long get(int l, int r) {
        return modular(h[r] - mul(h[l - 1], p[r - l + 1]));
    }

    public long mul(long a, long b) {
        long al = a & (1L << 31) - 1, ah = a >>> 31;
        long bl = b & (1L << 31) - 1, bh = b >>> 31;
        // <2^62
        long low = al * bl;
        // < 2^62
        long mid = al * bh + bl * ah;
        // < 2^60 + 2^31 < 2^61
        long high = ah * bh + (mid >>> 31);
        // high*2^62 = high*2 (mod 2^61-1)
        return modular(modular(2 * high + low) + ((mid & (1L << 31) - 1) << 31));
    }

    public long modular(long a) {
        while (a >= mod) {
            a -= mod;
        }
        while (a < 0) {
            a += mod;
        }
        return a;
    }
}
