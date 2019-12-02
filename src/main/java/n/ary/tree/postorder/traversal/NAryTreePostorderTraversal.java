package n.ary.tree.postorder.traversal;

import common.NAryNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class NAryTreePostorderTraversal {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(NAryNode root) {
        helper(root);
        return result;
    }

    private void helper(NAryNode root) {
        if (root == null) {
            return;
        }
        for (NAryNode child : root.children) {
            helper(child);
        }
        result.add(root.val);
    }
}
