package remove.palindromic.subsequences;

/**
 * @author hum
 */
public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        if (helper(s, 0, len - 1)) {
            return 1;
        }
        return 2;
    }

    private boolean helper(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
