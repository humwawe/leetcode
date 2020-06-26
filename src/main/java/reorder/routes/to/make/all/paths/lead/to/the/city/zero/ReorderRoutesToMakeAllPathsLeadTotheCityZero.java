package reorder.routes.to.make.all.paths.lead.to.the.city.zero;

import java.util.*;

/**
 * @author hum
 */
public class ReorderRoutesToMakeAllPathsLeadTotheCityZero {
    int result = 0;
    int[] h;
    int[] e;
    int[] ne;
    int[] w;
    int idx;

    public int minReorder(int n, int[][] connections) {
        h = new int[n + 5];
        e = new int[2 * n + 5];
        ne = new int[2 * n + 5];
        w = new int[2 * n + 5];
        Arrays.fill(h, -1);
        idx = 0;

        for (int[] connection : connections) {
            add(connection[0], connection[1], 1);
            add(connection[1], connection[0], -1);
        }
        helper(0, -1);
        return result;
    }

    private void helper(int u, int fa) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (fa == j) {
                continue;
            }
            if (w[i] == 1) {
                result++;
            }
            helper(j, u);
        }
    }

    void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

}
