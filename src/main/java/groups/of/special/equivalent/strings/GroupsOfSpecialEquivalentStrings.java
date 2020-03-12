package groups.of.special.equivalent.strings;

/**
 * @author hum
 */
public class GroupsOfSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] a) {
        int len = a.length;
        boolean[] vis = new boolean[len];
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (!vis[i]) {
                result++;
                for (int j = i + 1; j < len; j++) {
                    if (vis[j]) {
                        continue;
                    }
                    if (helper(a[i], a[j])) {
                        vis[j] = true;
                    }
                }
            }
        }
        return result;
    }

    private boolean helper(String s, String t) {
        int[] st = new int[26];
        int[] tt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c1 = s.charAt(i);
            int c2 = t.charAt(i);
            if (i % 2 == 0) {
                st[c1 - 'a']++;
                st[c2 - 'a']--;
            } else {
                tt[c1 - 'a']++;
                tt[c2 - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (st[i] != 0 || tt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
