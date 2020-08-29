package minimum.number.of.vertices.to.reach.all.nodes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> edge : edges) {
            set.add(edge.get(1));
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
