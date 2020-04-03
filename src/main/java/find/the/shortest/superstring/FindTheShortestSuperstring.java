package find.the.shortest.superstring;

import java.util.Arrays;

/**
 * @author hum
 */
public class FindTheShortestSuperstring {
    public String shortestSuperstring(String[] a) {
        int len = a.length;
        int[][] g = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                g[i][j] = calc(a[i], a[j]);
                g[j][i] = calc(a[j], a[i]);
            }
        }
        int[][] dp = new int[1 << len][len];
        int[][] p = new int[1 << len][len];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            Arrays.fill(p[i], -1);
        }
        for (int i = 0; i < len; ++i) {
            dp[1 << i][i] = a[i].length();
        }
        for (int i = 0; i < (1 << len); i++) {
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) == 0) {
                    continue;
                }
                int prev = i & (~(1 << j));
                for (int k = 0; k < len; k++) {
                    if (k == j || ((1 << k) & prev) == 0) {
                        continue;
                    }
                    if (dp[prev][k] + g[k][j] < dp[i][j]) {
                        dp[i][j] = dp[prev][k] + g[k][j];
                        p[i][j] = k;
                    }
                }
            }
        }
        int all = (1 << len) - 1;
        int end = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (dp[all][i] < min) {
                min = dp[all][i];
                end = i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (all > 0) {
            int prev = p[all][end];
            if (prev < 0) {
                stringBuilder.insert(0, a[end]);
                return stringBuilder.toString();
            } else {
                stringBuilder.insert(0, a[end].substring(a[end].length() - g[prev][end]));
            }
            all &= ~(1 << end);
            end = prev;
        }
        return stringBuilder.toString();
    }

    private int calc(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (b.startsWith(a.substring(i))) {
                return b.length() - a.length() + i;
            }
        }
        return b.length();
    }
}
