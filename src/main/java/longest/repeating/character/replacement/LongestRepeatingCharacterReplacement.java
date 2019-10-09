package longest.repeating.character.replacement;

/**
 * @author hum
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int result = 0;

        int[] alp = new int[26];
        int max = 0;
        while (r < len) {
            int tmp = s.charAt(r) - 'A';
            alp[tmp]++;
            max = Math.max(max, alp[tmp]);
            while ((r - l + 1 - max) > k) {
                alp[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
            r++;
        }
        return result;
    }

    private int helper(String s, int k) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int len2 = 26;
        int[][][] dp = new int[2][k + 1][len2];

        for (int i = 0; i <= k; i++) {
            int tmp = s.charAt(0) - 'A';
            for (int j = 0; j < len2; j++) {
                if (tmp == j || i > 0) {
                    dp[0][i][j] = 1;
                }
            }
        }
        int result = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l < len2; l++) {
                    int tmp = s.charAt(i) - 'A';
                    if (tmp == l) {
                        dp[i % 2][j][l] = dp[(i - 1) % 2][j][l] + 1;
                    } else {
                        if (j > 0) {
                            dp[i % 2][j][l] = dp[(i - 1) % 2][j - 1][l] + 1;
                        } else {
                            dp[i % 2][j][l] = 0;
                        }
                    }
                    result = Math.max(dp[i % 2][j][l], result);
                }
            }
        }
        return result;
    }
}
