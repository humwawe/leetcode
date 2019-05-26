package interleaving.string;

/**
 * @author hum
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.substring(0, i).equals(s3.substring(0, i))) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= s2.length(); i++) {
            if (s2.substring(0, i).equals(s3.substring(0, i))) {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1.length()][s2.length()];

//        return helper(s1, s2, s3);
    }

    private boolean helper(String s1, String s2, String s3) {
        if ((s1 + s2).equals(s3) || (s2 + s1).equals(s3)) {
            return true;
        }

        if (!s1.isEmpty() && s3.charAt(0) == s1.charAt(0)) {
            if (helper(s1.substring(1), s2, s3.substring(1))) {
                return true;
            }
        }
        if (!s2.isEmpty() && s3.charAt(0) == s2.charAt(0)) {
            if (helper(s1, s2.substring(1), s3.substring(1))) {
                return true;
            }
        }

        return false;
    }

    private boolean solve(String s1, String s2, String s3, int index1, int index2, int[][] res) {
        if (res[index1][index2] != 0) {
            return res[index1][index2] == 1;
        }
        if (index1 == s1.length() && index2 == s2.length()) {
            res[index1][index2] = 1;
            return true;
        }
        res[index1][index2] = -1;
        if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index1 + index2) && solve(s1, s2, s3, index1 + 1, index2, res)) {
            res[index1][index2] = 1;
            return true;
        }
        if (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index1 + index2) && solve(s1, s2, s3, index1, index2 + 1, res)) {
            res[index1][index2] = 1;
            return true;
        }
        return false;
    }

}
