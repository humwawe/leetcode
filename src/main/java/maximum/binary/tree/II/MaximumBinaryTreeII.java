package maximum.binary.tree.II;

import common.TreeNode;

/**
 * @author hum
 */
public class MaximumBinaryTreeII {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            TreeNode p = new TreeNode(val);
            p.left = root;
            return p;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
