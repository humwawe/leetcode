package shortest.common.supersequence;

/**
 * @author hum
 */
public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = len1;
        int j = len2;
        StringBuilder sb = new StringBuilder();
        while (i > 0 || j > 0) {
            char c;
            if (i == 0) {
                c = str2.charAt(j - 1);
                j--;
            } else if (j == 0) {
                c = str1.charAt(i - 1);
                i--;
            } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                c = str1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] == dp[i][j]) {
                c = str1.charAt(i - 1);
                i--;
            } else {
                c = str2.charAt(j - 1);
                j--;
            }
            sb.insert(0, c);
        }
        return sb.toString();
    }
}
