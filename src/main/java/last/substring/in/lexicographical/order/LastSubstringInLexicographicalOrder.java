package last.substring.in.lexicographical.order;

/**
 * @author hum
 */
public class LastSubstringInLexicographicalOrder {
    public String lastSubstring(String s) {
        int len = s.length();
        int i = 0;
        int j = 1;
        int k = 0;
        while (i + k < len && j + k < len) {
            int t = s.charAt(i + k) - s.charAt(j + k);
            if (t == 0) {
                k++;
                continue;
            }
            if (t < 0) {
                i = i + k + 1;
            } else {
                j = j + k + 1;
            }
            if (i == j) {
                j++;
            }
            k = 0;
        }
        return s.substring(Math.min(i, j));
    }
}
