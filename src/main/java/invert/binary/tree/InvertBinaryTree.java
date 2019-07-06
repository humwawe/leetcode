package invert.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode tmp = left;
        root.left = right;
        root.right = tmp;
        return root;
    }
}
