package n.ary.tree.preorder.traversal;

import common.NAryNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class NAryTreePreorderTraversal {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(NAryNode root) {
        helper(root);
        return result;
    }

    private void helper(NAryNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (NAryNode child : root.children) {
            helper(child);
        }
    }
}
