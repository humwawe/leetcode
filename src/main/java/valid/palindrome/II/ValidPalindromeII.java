package valid.palindrome.II;

/**
 * @author hum
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        return helper(s, 0, len - 1, 1);
    }

    private boolean helper(String s, int i, int j, int count) {
        if (count < 0) {
            return false;
        }
        if (i >= j) {
            return true;
        }
        if (s.charAt(i) != s.charAt(j)) {
            return helper(s, i + 1, j, count - 1) || helper(s, i, j - 1, count - 1);
        }
        return helper(s, i + 1, j - 1, count);
    }
}
