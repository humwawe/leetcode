package diameter.of.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class DiameterOfBinaryTree {
    int result;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }
}
