package number.of.ways.to.paint.n.three.grid;

import java.util.*;

/**
 * @author hum
 */
public class NumberfWaysToPaintN3Grid {
    List<String> list = new ArrayList<>();

    public int numOfWays(int n) {
        helper(0, -1, "");
        int len = list.size();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (check(list, i, j)) {
                    map.get(i).add(j);
                }
            }
        }
        int[][] dp = new int[n][len];
        for (int i = 0; i < len; i++) {
            dp[0][i] = 1;
        }
        int mod = (int) (1e9 + 7);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < len; j++) {
                for (Integer k : map.get(j)) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= mod;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            result += dp[n - 1][i];
            result %= mod;
        }
        return result;
    }

    private boolean check(List<String> list, int i, int j) {
        for (int k = 0; k < 3; k++) {
            if (list.get(i).charAt(k) == list.get(j).charAt(k)) {
                return false;
            }
        }
        return true;
    }

    private void helper(int i, int prev, String s) {
        if (i == 3) {
            list.add(s);
            return;
        }
        for (int j = 0; j < 3; j++) {
            if (prev == j) {
                continue;
            }
            helper(i + 1, j, s + j);
        }
    }
}
