package insufficient.nodes.in.root.to.leaf.paths;

import common.TreeNode;

/**
 * @author hum
 */
public class InsufficientNodesInRootToLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (helper(root, 0, limit)) {
            return null;
        }
        return root;
    }

    private boolean helper(TreeNode root, int sum, int limit) {
        if (root.left == null && root.right == null) {
            return sum + root.val < limit;
        }
        boolean l = true;
        boolean r = true;
        if (root.left != null) {
            l = helper(root.left, root.val + sum, limit);
        }
        if (root.right != null) {
            r = helper(root.right, root.val + sum, limit);
        }
        if (l) {
            root.left = null;
        }
        if (r) {
            root.right = null;
        }
        return l && r;
    }
}
