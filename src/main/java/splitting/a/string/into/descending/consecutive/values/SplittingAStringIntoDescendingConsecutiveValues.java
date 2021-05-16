package splitting.a.string.into.descending.consecutive.values;

/**
 * @author hum
 */
public class SplittingAStringIntoDescendingConsecutiveValues {
    public boolean splitString(String s) {
        long tmp = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            tmp = tmp * 10 + s.charAt(i) - '0';
            if (helper(s, i, tmp)) {
                return true;
            }
        }
        return false;
    }

    private boolean helper(String s, int i, long cur) {
        if (i == s.length() - 1) {
            return true;
        }
        long tmp = 0;
        for (int j = i + 1; j < s.length(); j++) {
            tmp = tmp * 10 + s.charAt(j) - '0';
            if (tmp == cur - 1) {
                if (helper(s, j, tmp)) {
                    return true;
                }
            }
        }
        return false;
    }

}
