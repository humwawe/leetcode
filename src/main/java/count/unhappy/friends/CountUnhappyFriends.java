package count.unhappy.friends;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class CountUnhappyFriends {
    int[][] rank;

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int result = 0;
        rank = new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                rank[i][preferences[i][j]] = j;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }
        for (int x = 0; x < n; x++) {
            int y = map.get(x);
            if (rank[x][y] > 0) {
                for (int j = 0; j < rank[x][y]; j++) {
                    int u = preferences[x][j];
                    int v = map.get(u);
                    if (check(u, x, v)) {
                        result++;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private boolean check(int u, int x, int v) {
        return rank[u][x] < rank[u][v];
    }
}
