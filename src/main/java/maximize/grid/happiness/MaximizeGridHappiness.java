package maximize.grid.happiness;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximizeGridHappiness {
    int len;

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        int inf = (int) (1e8 + 5);
        int lim = (int) Math.pow(3, n);
        len = n;
        int[][][][] dp = new int[m + 1][lim][introvertsCount + 1][extrovertsCount + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < lim; j++) {
                for (int k = 0; k < introvertsCount + 1; k++) {
                    Arrays.fill(dp[i][j][k], inf);
                }
            }
        }
        int[][] d = new int[lim][lim];
        int[] ic = new int[lim];
        int[] ec = new int[lim];
        for (int i = 0; i < lim; i++) {
            String lastS = helper(i);
            int[] lastC = helper2(lastS);
            ic[i] = lastC[0];
            ec[i] = lastC[1];
            for (int j = 0; j < lim; j++) {
                String curS = helper(j);
                int[] curC = helper2(curS);
                if (lastC[0] + curC[0] > introvertsCount || lastC[1] + curC[1] > extrovertsCount) {
                    continue;
                }
                int sum = 0;
                for (int p = 0; p < curS.length(); p++) {
                    if (curS.charAt(p) == '1') {
                        sum += 120;
                        if (lastS.charAt(p) == '1') {
                            sum -= 60;
                        }
                        if (lastS.charAt(p) == '2') {
                            sum -= 10;
                        }
                        if (p - 1 >= 0 && curS.charAt(p - 1) == '1') {
                            sum -= 60;
                        }
                        if (p - 1 >= 0 && curS.charAt(p - 1) == '2') {
                            sum -= 10;
                        }
                    }
                    if (curS.charAt(p) == '2') {
                        sum += 40;
                        if (lastS.charAt(p) == '1') {
                            sum -= 10;
                        }
                        if (lastS.charAt(p) == '2') {
                            sum += 40;
                        }
                        if (p - 1 >= 0 && curS.charAt(p - 1) == '1') {
                            sum -= 10;
                        }
                        if (p - 1 >= 0 && curS.charAt(p - 1) == '2') {
                            sum += 40;
                        }
                    }
                    d[i][j] = sum;
                }
            }
        }

        dp[0][0][0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < lim; j++) {
                for (int k = 0; k <= introvertsCount; k++) {
                    for (int l = 0; l <= extrovertsCount; l++) {
                        int last = dp[i - 1][j][k][l];
                        if (last == inf) {
                            continue;
                        }
                        for (int o = 0; o < lim; o++) {
                            if (ic[o] + k > introvertsCount || ec[o] + l > extrovertsCount) {
                                continue;
                            }
                            int sum = last + d[j][o];
                            if (dp[i][o][ic[o] + k][ec[o] + l] == inf) {
                                dp[i][o][ic[o] + k][ec[o] + l] = sum;
                            } else {
                                dp[i][o][ic[o] + k][ec[o] + l] = Math.max(dp[i][o][ic[o] + k][ec[o] + l], sum);
                            }

                        }
                    }
                }
            }
        }
        int res = 0;
        for (int j = 0; j < lim; j++) {
            for (int k = 0; k <= introvertsCount; k++) {
                for (int l = 0; l <= extrovertsCount; l++) {
                    if (dp[m][j][k][l] != inf) {
                        res = Math.max(res, dp[m][j][k][l]);
                    }
                }
            }
        }
        return res;
    }

    private int[] helper2(String last) {
        int[] res = new int[2];
        for (int i = 0; i < last.length(); i++) {
            if (last.charAt(i) == '1') {
                res[0]++;
            } else if (last.charAt(i) == '2') {
                res[1]++;
            }
        }
        return res;
    }

    private String helper(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            int x = n % 3;
            n = n / 3;
            res.insert(0, x);
        }
        while (res.length() < len) {
            res.insert(0, 0);
        }
        return res.toString();
    }
}
