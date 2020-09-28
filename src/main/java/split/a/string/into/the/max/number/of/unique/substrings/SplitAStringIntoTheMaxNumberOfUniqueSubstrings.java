package split.a.string.into.the.max.number.of.unique.substrings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    int res = 0;
    Set<String> set = new HashSet<>();

    public int maxUniqueSplit(String s) {
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start) {
        if (set.size() + s.length() - start <= res) {
            return;
        }
        if (start == s.length()) {
            if (set.size() > res) {
                res = set.size();
            }
            return;
        }
        for (int i = start; i < s.length(); ++i) {
            String sub = s.substring(start, i + 1);
            if (!set.contains(sub)) {
                set.add(sub);
                dfs(s, i + 1);
                set.remove(sub);
            }
        }
    }
}
