package score.of.parentheses;

/**
 * @author hum
 */
public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        return helper(chars, 0, len - 1);
    }

    private int helper(char[] chars, int i, int j) {
        if (i + 1 == j) {
            return 1;
        }
        int count = 0;
        int k = i;
        for (; k <= j; k++) {
            if (chars[k] == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                break;
            }
        }
        if (k == j) {
            return 2 * helper(chars, i + 1, j - 1);
        } else {
            return helper(chars, i, k) + helper(chars, k + 1, j);
        }
    }
}
