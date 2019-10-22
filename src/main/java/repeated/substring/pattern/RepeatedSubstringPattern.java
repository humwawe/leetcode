package repeated.substring.pattern;

/**
 * @author hum
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (helper(s, s.substring(0, i))) {
                return true;
            }
        }
        return false;
    }

    private boolean helper(String s, String pre) {
        if (s.length() == 0) {
            return true;
        }
        if (s.startsWith(pre)) {
            return helper(s.substring(pre.length()), pre);
        }
        return false;
    }
}
