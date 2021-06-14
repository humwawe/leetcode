package maximum.number.of.removable.characters;

/**
 * @author hum
 */
public class MaximumNumberOfRemovableCharacters {
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0;
        int r = removable.length;
        boolean[] vis = new boolean[s.length()];
        while (l < r) {
            int mid = l + r + 1 >> 1;
            for (int i = 0; i < mid; i++) {
                vis[removable[i]] = true;
            }
            if (check(s, p, vis)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(String s, String p, boolean[] vis) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vis[i]) {
                continue;
            }
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == p.length()) {
                return true;
            }
        }
        return false;
    }
}
