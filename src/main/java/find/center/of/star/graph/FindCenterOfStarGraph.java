package find.center.of.star.graph;

/**
 * @author hum
 */
public class FindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] cnt = new int[n + 1];
        for (int[] edge : edges) {
            cnt[edge[0]]++;
            cnt[edge[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
