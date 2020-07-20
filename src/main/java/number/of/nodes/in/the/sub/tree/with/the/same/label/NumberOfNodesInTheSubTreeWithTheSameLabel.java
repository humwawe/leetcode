package number.of.nodes.in.the.sub.tree.with.the.same.label;

import java.util.Arrays;

/**
 * @author hum
 */
public class NumberOfNodesInTheSubTreeWithTheSameLabel {
    int N = (int) (1e5) + 5;
    int M = 2 * N;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;
    String s;
    int[] result;
    int n;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Arrays.fill(h, -1);
        idx = 0;
        s = labels;
        this.n = n;
        result = new int[n];
        for (int[] e : edges) {
            add(e[0], e[1]);
            add(e[1], e[0]);
        }
        helper(0, 0);
        return result;
    }

    private int[] helper(int u, int p) {
        int[] res = new int[26];
        res[s.charAt(u) - 'a']++;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == p) {
                continue;
            }
            int[] tmp = helper(j, u);
            for (int k = 0; k < 26; k++) {
                res[k] += tmp[k];
            }
        }
        result[u] = res[s.charAt(u) - 'a'];
        return res;
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

}
