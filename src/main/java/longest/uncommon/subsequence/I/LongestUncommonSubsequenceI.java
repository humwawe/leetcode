package longest.uncommon.subsequence.I;

/**
 * @author hum
 */
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return a.length() >= b.length() ? a.length() : b.length();
    }
}
