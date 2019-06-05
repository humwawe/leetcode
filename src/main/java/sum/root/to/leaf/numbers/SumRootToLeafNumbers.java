package sum.root.to.leaf.numbers;

import common.TreeNode;

/**
 * @author hum
 */
public class SumRootToLeafNumbers {
    private int result = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return result;
        }
        helper(root, 0);
        return result;

    }

    private void helper(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            result += sum * 10 + root.val;
            return;
        }
        sum = sum * 10 + root.val;
        if (root.left != null) {
            helper(root.left, sum);
        }
        if (root.right != null) {
            helper(root.right, sum);
        }
    }
}
