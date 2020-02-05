package all.paths.from.source.to.target;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class AllPathsFromSourceToTarget {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        helper(graph, 0, new ArrayList<>());
        for (List<Integer> list : result) {
            list.add(graph.length - 1);
        }
        return result;
    }

    private void helper(int[][] graph, int start, List<Integer> tmp) {
        if (start == graph.length - 1) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(start);
        for (int i : graph[start]) {
            helper(graph, i, tmp);
        }
        tmp.remove(tmp.size() - 1);
    }
}
