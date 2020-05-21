package delete.nodes.and.ret.forest;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class DeleteNodesAndReturnForest {
    Set<Integer> set = new HashSet<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        for (int i : toDelete) {
            set.add(i);
        }
        root = helper(root);
        if (root != null) {
            result.add(root);
        }
        return result;
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = helper(root.left);
        root.right = helper(root.right);
        if (set.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }
        return root;
    }
}
