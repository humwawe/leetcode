package insert.into.a.binary.search.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        helper(root, root, val);
        return root;
    }

    private void helper(TreeNode root, TreeNode prev, int val) {
        if (root == null) {
            if (prev.val > val) {
                prev.left = new TreeNode(val);
            } else {
                prev.right = new TreeNode(val);
            }
            return;
        }
        if (root.val > val) {
            helper(root.left, root, val);
        }
        if (root.val < val) {
            helper(root.right, root, val);
        }
    }
}
