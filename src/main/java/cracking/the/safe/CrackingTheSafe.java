package cracking.the.safe;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int total = (int) (Math.pow(k, n));
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        Set<String> vis = new HashSet<>();
        vis.add(sb.toString());
        helper(sb, total, vis, n, k);
        return sb.toString();
    }

    private boolean helper(StringBuilder result, int total, Set<String> vis, int n, int k) {
        if (vis.size() == total) {
            return true;
        }
        String prev = result.substring(result.length() - n + 1);
        for (int i = 0; i < k; i++) {
            String cur = prev + i;
            if (!vis.contains(cur)) {
                vis.add(cur);
                result.append(i);
                if (helper(result, total, vis, n, k)) {
                    return true;
                }
                vis.remove(cur);
                result.delete(result.length() - 1, result.length());
            }

        }
        return false;
    }
}
