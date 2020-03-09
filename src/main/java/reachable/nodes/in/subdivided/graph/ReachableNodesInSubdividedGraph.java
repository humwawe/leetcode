package reachable.nodes.in.subdivided.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class ReachableNodesInSubdividedGraph {
    public int reachableNodes(int[][] edges, int m, int n) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.computeIfAbsent(u, x -> new HashMap<>()).put(v, w);
            graph.computeIfAbsent(v, x -> new HashMap<>()).put(u, w);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Map<Integer, Integer> vis = new HashMap<>();
        queue.add(new int[]{m, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int hp = poll[0];
            int cur = poll[1];
            if (vis.containsKey(cur)) {
                continue;
            }
            vis.put(cur, hp);
            if (!graph.containsKey(cur)) {
                continue;
            }
            for (Map.Entry<Integer, Integer> pair : graph.get(cur).entrySet()) {
                int next = pair.getKey();
                int nextHp = hp - pair.getValue() - 1;
                if (vis.containsKey(next) || nextHp < 0) {
                    continue;
                }
                queue.add(new int[]{nextHp, next});
            }
        }
        int result = vis.size();
        for (int[] edge : edges) {
            int uHp = vis.getOrDefault(edge[0], 0);
            int vHp = vis.getOrDefault(edge[1], 0);
            result += Math.min(edge[2], uHp + vHp);
        }
        return result;
    }
}
