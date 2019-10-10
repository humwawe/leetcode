package common;

import java.util.List;

/**
 * @author hum
 */
public class NAryNode {
    public int val;
    public List<NAryNode> children;

    public NAryNode() {
    }

    public NAryNode(int val, List<NAryNode> children) {
        this.val = val;
        this.children = children;
    }
}
