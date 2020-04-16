package distribute.coins.in.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class DistributeCoinsInBinaryTree {
    int result = 0;

    public int distributeCoins(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = helper(root.left);
        int b = helper(root.right);
        result += Math.abs(a) + Math.abs(b);
        return a + b + root.val - 1;
    }
}
