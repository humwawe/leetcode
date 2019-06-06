package common;

import java.util.List;

/**
 * @author hum
 */
public class NeighborsNode {
    public int val;
    public List<NeighborsNode> neighbors;

    public NeighborsNode() {
    }

    public NeighborsNode(int val, List<NeighborsNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
