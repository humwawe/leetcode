package minimum.length.of.string.after.deleting.similar.ends;

/**
 * @author hum
 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    public int minimumLength(String s) {
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            char l = s.charAt(i);
            char r = s.charAt(j);
            while (i <= j && s.charAt(i) == l) {
                i++;
            }
            while (i <= j && s.charAt(j) == r) {
                j--;
            }
        }
        return j - i + 1;
    }
}
