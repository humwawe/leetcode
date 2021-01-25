package minimum.number.of.people.to.teach;

import java.util.*;

/**
 * @author hum
 */
public class MinimumNumberOfPeopleToTeach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int res = Integer.MAX_VALUE;
        boolean[][] vis = new boolean[505][505];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            for (int j = 0; j < languages[i].length; j++) {
                vis[i + 1][languages[i][j]] = true;
            }
        }
        List<Integer> list = new ArrayList<>();
        f:
        for (int i = 0, friendshipsLength = friendships.length; i < friendshipsLength; i++) {
            int[] friendship = friendships[i];
            for (int j = 1; j <= n; j++) {
                if (vis[friendship[0]][j] && vis[friendship[1]][j]) {
                    continue f;
                }
            }
            list.add(i);
        }

        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            for (Integer j : list) {
                int[] friendship = friendships[j];
                if (!vis[friendship[0]][i]) {
                    tmp++;
                    vis[friendship[0]][i] = true;
                }
                if (!vis[friendship[1]][i]) {
                    tmp++;
                    vis[friendship[1]][i] = true;
                }
            }
            res = Math.min(res, tmp);
        }
        return res;
    }
}
