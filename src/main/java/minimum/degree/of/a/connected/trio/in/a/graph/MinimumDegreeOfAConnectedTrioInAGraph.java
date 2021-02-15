package minimum.degree.of.a.connected.trio.in.a.graph;

/**
 * @author hum
 */
public class MinimumDegreeOfAConnectedTrioInAGraph {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] e = new boolean[n + 1][n + 1];
        int[] cnt = new int[n + 1];
        for (int[] edge : edges) {
            e[edge[0]][edge[1]] = true;
            e[edge[1]][edge[0]] = true;
            cnt[edge[0]]++;
            cnt[edge[1]]++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!e[i][j]) {
                    continue;
                }
                for (int k = 1; k <= n; k++) {
                    if (e[j][k] && e[i][k]) {
                        res = Math.min(res, cnt[i] + cnt[j] + cnt[k] - 6);
                    }
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }
}
