package check.an.original.string.exists.given.two.encoded.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class CheckIfAnOriginalStringExistsGivenTwoEncodedStrings {
    public boolean possiblyEquals(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        Set<Integer>[][] dp = new Set[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        dp[0][0].add(0);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int delta : dp[i][j]) {
                    int num = 0;
                    for (int k = i; k < Math.min(n, i + 3); k++) {
                        if (Character.isDigit(s1.charAt(k))) {
                            num = num * 10 + s1.charAt(k) - '0';
                            dp[k + 1][j].add(delta + num);
                        } else {
                            break;
                        }
                    }
                    num = 0;
                    for (int k = j; k < Math.min(m, j + 3); k++) {
                        if (Character.isDigit(s2.charAt(k))) {
                            num = num * 10 + s2.charAt(k) - '0';
                            dp[i][k + 1].add(delta - num);
                        } else {
                            break;
                        }
                    }
                    if (i < n && delta < 0 && Character.isAlphabetic(s1.charAt(i))) {
                        dp[i + 1][j].add(delta + 1);
                    }
                    if (j < m && delta > 0 && Character.isAlphabetic(s2.charAt(j))) {
                        dp[i][j + 1].add(delta - 1);
                    }
                    if (i < n && j < m && delta == 0 && s1.charAt(i) == s2.charAt(j)) {
                        dp[i + 1][j + 1].add(0);
                    }
                }
            }
        }

        return dp[n][m].contains(0);
    }
}
