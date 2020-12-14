package count.the.number.of.consistent.strings;

/**
 * @author hum
 */
public class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] vis = new boolean[26];
        for (char c : allowed.toCharArray()) {
            vis[c - 'a'] = true;
        }
        int res = 0;
        b:
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!vis[c - 'a']) {
                    continue b;
                }
            }
            res++;
        }
        return res;
    }
}
