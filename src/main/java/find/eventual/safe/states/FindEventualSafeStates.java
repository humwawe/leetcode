package find.eventual.safe.states;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FindEventualSafeStates {
    int[] color;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        color = new int[len];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (!helper(graph, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean helper(int[][] graph, int i) {
        if (color[i] == 1) {
            return true;
        }
        if (color[i] != 0) {
            return color[i] == 3;
        }
        color[i] = 1;
        for (int j : graph[i]) {
            if (helper(graph, j)) {
                color[i] = 3;
                return true;
            }
        }
        color[i] = 2;
        return false;
    }
}
