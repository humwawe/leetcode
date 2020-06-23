package minimum.number.of.frogs.croaking;

/**
 * @author hum
 */
public class MinimumNumberOfFrogsCroaking {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0, result = 0;
        for (char x : croakOfFrogs.toCharArray()) {
            if (x == 'c') {
                c += 1;
            } else if (x == 'r') {
                r += 1;
            } else if (x == 'o') {
                o += 1;
            } else if (x == 'a') {
                a += 1;
            } else if (x == 'k') {
                k += 1;
            } else {
                return -1;
            }
            if (r > c || o > r || a > o || k > a) {
                return -1;
            }
            result = Math.max(c, result);
            if (k == 1) {
                c -= 1;
                r -= 1;
                o -= 1;
                a -= 1;
                k -= 1;
            }
        }
        if (c != 0) {
            return -1;
        }
        return result;
    }
}
