package longest.duplicate.substring;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class LongestDuplicateSubstring {
    int n = 100005;
    long[] h = new long[n];
    long[] h2 = new long[n];
    long[] p = new long[n];
    long[] p2 = new long[n];
    int mod = (int) (1e9 + 7);
    int P = 131;
    int P2 = 13331;

    public String longestDupSubstring(String s) {
        p[0] = 1;
        p2[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            h[i] = (h[i - 1] * P + s.charAt(i - 1)) % mod;
            p[i] = p[i - 1] * P % mod;
            h2[i] = (h2[i - 1] * P2 + s.charAt(i - 1)) % mod;
            p2[i] = p2[i - 1] * P2 % mod;
        }
        int l = 1, r = s.length();
        int mid;
        while (l != r) {
            mid = l + r + 1 >> 1;
            if (check(mid, s.length()) != -1) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int index = check(l, s.length());
        if (index != -1) {
            return s.substring(index - 1, index + l - 1);
        }
        return "";
    }

    private int check(int len, int length) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 1; i <= length - len + 1; i++) {
            if (set.contains(get(i, i + len - 1)) && set2.contains(get2(i, i + len - 1))) {
                return i;
            }
            set.add(get(i, i + len - 1));
            set2.add(get2(i, i + len - 1));
        }
        return -1;
    }

    int get(int l, int r) {
        return (int) ((h[r] - h[l - 1] * p[r - l + 1] % mod + mod) % mod);
    }

    int get2(int l, int r) {
        return (int) ((h2[r] - h2[l - 1] * p2[r - l + 1] % mod + mod) % mod);
    }

}
