package longest.happy.prefix;

/**
 * @author hum
 */
public class LongestHappyPrefix {
    public String longestPrefix(String s) {
        int len = s.length();
        int[] next = new int[len + 1];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < len) {
            while (-1 != j && s.charAt(i) != s.charAt(j)) {
                j = next[j];
            }
            next[++i] = ++j;
        }
        return s.substring(0, next[len]);
    }

}
