package network.delay.time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class NetworkDelayTime {
    Map<Integer, Integer> dist = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<int[]>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        for (int node = 1; node <= n; ++node) {
            dist.put(node, Integer.MAX_VALUE);
        }

        dfs(graph, k, 0);
        int ans = 0;
        for (int value : dist.values()) {
            if (value == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, value);
        }
        return ans;
    }

    public void dfs(Map<Integer, List<int[]>> graph, int node, int sum) {
        if (sum >= dist.get(node)) {
            return;
        }
        dist.put(node, sum);
        if (graph.containsKey(node)) {
            for (int[] info : graph.get(node)) {
                dfs(graph, info[0], sum + info[1]);
            }
        }
    }
}
