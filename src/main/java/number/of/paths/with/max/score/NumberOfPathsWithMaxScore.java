package number.of.paths.with.max.score;

import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class NumberOfPathsWithMaxScore {
    public int[] pathsWithMaxScore(List<String> board) {
        int len = board.size();
        int inf = (int) 1e9;
        int mod = (int) (1e9 + 7);
        int[][] dist = new int[len + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dist[i], -inf);
        }
        long[][] cnt = new long[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                char c = board.get(i - 1).charAt(j - 1);
                if (c == 'E') {
                    dist[i][j] = 0;
                    cnt[i][j] = 1;
                    continue;
                }
                if (c == 'S') {
                    c = '0';
                }
                if (board.get(i - 1).charAt(j - 1) == 'X') {
                    continue;
                }
                int tmp = Math.max(Math.max(dist[i - 1][j], dist[i][j - 1]), dist[i - 1][j - 1]);
                if (tmp == -inf) {
                    continue;
                }
                dist[i][j] = tmp + c - '0';
                if (dist[i - 1][j] == tmp) {
                    cnt[i][j] += cnt[i - 1][j];
                }
                if (dist[i - 1][j - 1] == tmp) {
                    cnt[i][j] += cnt[i - 1][j - 1];
                }
                if (dist[i][j - 1] == tmp) {
                    cnt[i][j] += cnt[i][j - 1];
                }
                cnt[i][j] %= mod;
            }
        }

        if (dist[len][len] == -inf) {
            return new int[]{0, 0};
        }
        return new int[]{dist[len][len], (int) (cnt[len][len] % mod)};
    }
}
