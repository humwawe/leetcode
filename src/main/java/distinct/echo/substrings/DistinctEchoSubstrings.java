package distinct.echo.substrings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class DistinctEchoSubstrings {
    int P = 131;
    int n = 100;
    long[] h = new long[2005];
    long[] p = new long[2005];
    int mod = (int) (1e9 + 7);

    public int distinctEchoSubstrings(String text) {
        int len = text.length();
        p[0] = 1;
        for (int i = 1; i <= len; i++) {
            h[i] = (h[i - 1] * P + text.charAt(i - 1)) % mod;
            p[i] = p[i - 1] * P % mod;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= len; i++) {
            for (int j = i; 2 * j + 1 - i <= len; j++) {
                int tmp = get(i, j);
                if (set.contains(tmp)) {
                    continue;
                }
                if (tmp == get(j + 1, j + 1 + j - i)) {
                    set.add(tmp);
                }
            }
        }
        return set.size();
    }

    int get(int l, int r) {
        return (int) ((h[r] - h[l - 1] * p[r - l + 1] % mod + mod) % mod);
    }

}
