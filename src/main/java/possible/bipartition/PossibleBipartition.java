package possible.bipartition;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : dislikes) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, x -> new HashSet<>()).add(v);
            graph.computeIfAbsent(v, x -> new HashSet<>()).add(u);
        }
        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0 && !helper(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;

    }

    private boolean helper(Map<Integer, Set<Integer>> graph, int[] colors, int i, int color) {
        if (colors[i] != 0) {
            return colors[i] == color;
        }
        colors[i] = color;
        Set<Integer> set = graph.get(i);
        if (set == null) {
            return true;
        }
        for (Integer child : set) {
            if (!helper(graph, colors, child, -color)) {
                return false;
            }
        }
        return true;
    }
}
