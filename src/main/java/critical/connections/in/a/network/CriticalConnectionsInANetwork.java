package critical.connections.in.a.network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class CriticalConnectionsInANetwork {
    int[] h = new int[100005];
    int[] e = new int[100005 * 2];
    int[] ne = new int[100005 * 2];
    int idx;
    int[] dfn;
    int[] low;
    boolean[] vis;
    int t;
    List<List<Integer>> result;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        result = new ArrayList<>();
        Arrays.fill(h, -1);
        idx = 0;
        dfn = new int[n];
        low = new int[n];
        vis = new boolean[n];
        t = 0;
        for (List<Integer> connection : connections) {
            add(connection.get(0), connection.get(1));
            add(connection.get(1), connection.get(0));
        }
        tarjan(0, -1);
        return result;
    }

    private void tarjan(int cur, int pre) {
        t++;
        dfn[cur] = t;
        low[cur] = t;
        vis[cur] = true;
        for (int i = h[cur]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == pre) {
                continue;
            }
            if (!vis[j]) {
                tarjan(j, cur);
                low[cur] = Math.min(low[cur], low[j]);
                if (low[j] > dfn[cur]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(j);
                    result.add(list);
                }
            } else {
                low[cur] = Math.min(low[cur], dfn[j]);
            }
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
