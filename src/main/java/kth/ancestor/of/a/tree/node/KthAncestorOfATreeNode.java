package kth.ancestor.of.a.tree.node;

import java.util.Arrays;

/**
 * @author hum
 */
public class KthAncestorOfATreeNode {
    int[][] f = new int[50005][17];

    public KthAncestorOfATreeNode(int n, int[] parent) {
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], -1);
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                continue;
            }
            f[i][0] = parent[i];
            for (int j = 1; j <= 16; j++) {
                if (f[i][j - 1] == -1) {
                    break;
                }
                f[i][j] = f[f[i][j - 1]][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < 16; i++) {
            if (((k >> i) & 1) == 1) {
                node = f[node][i];
                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;
    }
}
