package possible.bipartition;


import java.util.*;

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

    int[] h = new int[2005];
    int[] ne = new int[10005];
    int[] e = new int[10005];

    public boolean possibleBipartition2(int n, int[][] dislikes) {
        Arrays.fill(h, -1);
        int m = 0;
        for (int[] dislike : dislikes) {
            e[m] = dislike[1];
            ne[m] = h[dislike[0]];
            h[dislike[0]] = m++;
            e[m] = dislike[0];
            ne[m] = h[dislike[1]];
            h[dislike[1]] = m++;
        }
        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0 && !dfs(colors, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] colors, int i, int color) {
        if (colors[i] != 0) {
            return colors[i] == color;
        }
        colors[i] = color;
        for (int j = h[i]; j != -1; j = ne[j]) {
            if (!dfs(colors, e[j], -color)) {
                return false;
            }
        }
        return true;
    }

}
