package numbers.at.most.n.given.digit.set;

/**
 * @author hum
 */
public class NumbersAtMostNGivenDigitSet {
    int result = 0;

    public int atMostNGivenDigitSet(String[] d, int n) {
        for (int i = 1; i < String.valueOf(n).length(); i++) {
            result += Math.pow(d.length, i);
        }
        helper(d, String.valueOf(n), 0);
        return result;
    }

    private void helper(String[] d, String n, int pos) {
        if (pos == n.length()) {
            result += 1;
            return;
        }
        for (String s : d) {
            if (s.charAt(0) < n.charAt(pos)) {
                result += Math.pow(d.length, n.length() - pos - 1);
            }
            if (s.charAt(0) == n.charAt(pos)) {
                helper(d, n, pos + 1);
            }
        }
    }
}
