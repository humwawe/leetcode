package unique.length3.palindromic.subsequences;

/**
 * @author hum
 */
public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            int fi = s.indexOf(c);
            int se = s.lastIndexOf(c);
            boolean[] vis = new boolean[26];
            if (fi < se) {
                for (int j = fi + 1; j < se; j++) {
                    vis[s.charAt(j) - 'a'] = true;
                }
            }
            for (int j = 0; j < 26; j++) {
                if (vis[j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
