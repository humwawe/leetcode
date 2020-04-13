package univalued.binary.tree;

import common.TreeNode;


/**
 * @author hum
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.val) && helper(root.right, root.val);

    }

    private boolean helper(TreeNode r, int val) {
        if (r == null) {
            return true;
        }
        if (r.val != val) {
            return false;
        }
        return helper(r.left, val) && helper(r.right, val);
    }
}
