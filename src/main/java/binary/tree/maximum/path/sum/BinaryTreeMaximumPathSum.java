package binary.tree.maximum.path.sum;

import common.TreeNode;

/**
 * @author hum
 */
public class BinaryTreeMaximumPathSum {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        result = Math.max(result, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

}
