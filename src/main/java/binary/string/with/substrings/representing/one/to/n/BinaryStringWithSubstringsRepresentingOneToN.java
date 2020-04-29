package binary.string.with.substrings.representing.one.to.n;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class BinaryStringWithSubstringsRepresentingOneToN {
    public boolean queryString(String s, int n) {
        int len = s.length();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                continue;
            }
            for (int j = i + 1; j <= len && j < i + 32; j++) {
                int t = Integer.valueOf(s.substring(i, j), 2);
                System.out.println(t);
                if (t <= n) {
                    set.add(t);
                }
            }
        }
        System.out.println(set);
        return set.size() >= n;
    }
}
