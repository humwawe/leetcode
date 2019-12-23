package redundant.connection.II;

/**
 * @author hum
 */
public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }
        int[] c1 = new int[2];
        int[] c2 = new int[2];

        int[] parent = new int[edges.length + 1];
        for (int[] edge : edges) {
            if (parent[edge[1]] != 0) {
                c1 = new int[]{parent[edge[1]], edge[1]};
                c2 = new int[]{edge[0], edge[1]};
                break;
            }
            parent[edge[1]] = edge[0];
        }
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] e : edges) {
            if ((e[0] == c1[0] && e[1] == c1[1]) || (e[0] == c2[0] && e[1] == c2[1])) {
                continue;
            }
            if (!uf.union(e[0], e[1])) {
                return e;
            }
        }
        if (!uf.union(c1[0], c1[1])) {
            return c1;
        }
        return c2;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) {
                return false;
            }
            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else {
                parent[pb] = pa;
                if (rank[pa] == rank[pb]) {
                    rank[pa]++;
                }
            }
            return true;
        }

        int find(int a) {
            while (a != parent[a]) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }
    }
}
