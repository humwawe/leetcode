package valid.parenthesis.string;

/**
 * @author hum
 */
public class ValidParenthesisString {
    private int[][] memo;

    public boolean checkValidString(String s) {
        memo = new int[s.length()][s.length() + 1];
        return helper(s, 0, 0);
    }

    private boolean helper(String s, int i, int count) {
        if (i == s.length()) {
            return count == 0;
        }
        if (count < 0) {
            return false;
        }
        if (memo[i][count] != 0) {
            return memo[i][count] == 0;
        }
        if (s.charAt(i) == '(') {
            if (helper(s, i + 1, count + 1)) {
                memo[i][count] = 1;
                return true;
            } else {
                memo[i][count] = -1;
                return false;
            }
        } else if (s.charAt(i) == ')') {
            if (helper(s, i + 1, count - 1)) {
                memo[i][count] = 1;
                return true;
            } else {
                memo[i][count] = -1;
                return false;
            }
        } else {
            if (helper(s, i + 1, count) || helper(s, i + 1, count + 1) || helper(s, i + 1, count - 1)) {
                memo[i][count] = 1;
                return true;
            } else {
                memo[i][count] = -1;
                return false;
            }
        }
    }
}
