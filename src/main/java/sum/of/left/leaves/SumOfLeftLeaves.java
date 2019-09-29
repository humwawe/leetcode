package sum.of.left.leaves;

import common.TreeNode;

/**
 * @author hum
 */
public class SumOfLeftLeaves {
    int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, -1);
        return result;
    }

    private void helper(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (i == 0 && root.left == null && root.right == null) {
            result += root.val;
        }
        helper(root.left, 0);
        helper(root.right, 1);
    }
}
