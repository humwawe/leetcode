package minimum.changes.to.make.alternating.binary.string;

/**
 * @author hum
 */
public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        int res1 = 0;
        int res2 = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' == j) {
                res1++;
            } else {
                res2++;
            }
            j = 1 - j;
        }
        return Math.min(res1, res2);
    }
}
