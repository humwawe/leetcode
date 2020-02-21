package similar.string.groups;

/**
 * @author hum
 */
public class SimilarStringGroups {
    private int[] parent;

    public int numSimilarGroups(String[] a) {
        int len = a.length;
        parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (similar(a[i], a[j])) {
                    union(i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (parent[i] == i) {
                res++;
            }
        }
        return res;
    }

    private boolean similar(String w1, String w2) {
        int diff = 0;
        int n = w1.length();
        for (int i = 0; i < n; i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diff++;
            }
        }
        return diff <= 2;
    }

    private int find(int node) {
        return parent[node] == node ? node : (parent[node] = find(parent[node]));
    }

    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 == root2) {
            return;
        }
        parent[root1] = root2;
    }
}
