package clone.graph;

import common.NeighborsNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class CloneGraph {
    private Map<Integer, NeighborsNode> map = new HashMap<>();

    public NeighborsNode cloneGraph(NeighborsNode node) {
        System.out.println(node.val);
        return helper(node);

    }

    private NeighborsNode helper(NeighborsNode node) {
        NeighborsNode head = new NeighborsNode(node.val, new ArrayList<>());
        map.put(node.val, head);
        for (NeighborsNode neighborsNode : node.neighbors) {
            if (map.containsKey(neighborsNode.val)) {
                head.neighbors.add(map.get(neighborsNode.val));
            } else {
                head.neighbors.add(helper(neighborsNode));
            }
        }
        return head;
    }
}
