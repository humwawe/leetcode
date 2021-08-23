package find.path.exists.in.graph;

/**
 * @author hum
 */
public class FindIfPathExistsInGraph {
    int N = (int) (2e5 + 5);
    int[] p = new int[N];

    public boolean validPath(int n, int[][] edges, int start, int end) {
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int[] edge : edges) {
            if (find(edge[0]) != find(edge[1])) {
                p[find(edge[0])] = find(edge[1]);
            }
        }
        return find(start) == find(end);
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
