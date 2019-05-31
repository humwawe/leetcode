package distinct.subsequences;

/**
 * @author hum
 */
public class DistinctSubsequences {
    private int result = 0;

    public int numDistinct(String s, String t) {
        int[][] result = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j <= s.length(); j++) {
            result[0][j] = 1;
        }

        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + result[i][j - 1];
                } else {
                    result[i][j] = result[i][j - 1];
                }
            }
        }
        return result[t.length()][s.length()];
    }

    private void helper(String s, String t, int index) {
        if (index == t.length()) {
            result++;
            return;
        }
        if (s.length() == 0) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(index)) {
                helper(s.substring(i + 1), t, index + 1);
            }
        }
    }
}
