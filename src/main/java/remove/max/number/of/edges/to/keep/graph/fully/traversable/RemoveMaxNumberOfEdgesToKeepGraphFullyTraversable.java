package remove.max.number.of.edges.to.keep.graph.fully.traversable;

import java.util.Arrays;

/**
 * @author hum
 */
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    int[] p1 = new int[(int) (1e5 + 5)];
    int[] p2 = new int[(int) (1e5 + 5)];

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            p1[i] = i;
            p2[i] = i;
        }
        int res = 0;
        for (int[] edge : edges) {
            int t = edge[0];
            int a = edge[1];
            int b = edge[2];
            if (t == 3) {
                if ((find(a, p1) == find(b, p1)) && (find(a, p2) == find(b, p2))) {
                    res++;
                } else {
                    p1[find(a, p1)] = find(b, p1);
                    p2[find(a, p2)] = find(b, p2);
                }
            } else if (t == 2) {
                if (find(a, p2) == find(b, p2)) {
                    res++;
                } else {
                    p2[find(a, p2)] = find(b, p2);
                }
            } else {
                if (find(a, p1) == find(b, p1)) {
                    res++;
                } else {
                    p1[find(a, p1)] = find(b, p1);
                }
            }
        }
        int parent1 = find(0, p1);
        for (int i = 0; i < n; i++) {
            if (find(i, p1) != parent1) {
                return -1;
            }
        }
        int parent2 = find(0, p2);
        for (int i = 0; i < n; i++) {
            if (find(i, p2) != parent2) {
                return -1;
            }
        }
        return res;
    }

    int find(int x, int[] p) {
        if (p[x] != x) {
            p[x] = find(p[x], p);
        }
        return p[x];
    }
}
