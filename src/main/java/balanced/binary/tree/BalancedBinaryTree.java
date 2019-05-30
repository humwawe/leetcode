package balanced.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
//        return helper(root).isB;
        return helper2(root) != -1;
    }

    private ReturnResult helper(TreeNode root) {
        if (root == null) {
            return new ReturnResult(0, true);
        }

        ReturnResult left = helper(root.left);
        ReturnResult right = helper(root.right);
        if (!left.isB || !right.isB || Math.abs(left.depth - right.depth) > 1) {
            return new ReturnResult(0, false);
        }
        return new ReturnResult(Math.max(left.depth, right.depth) + 1, true);
    }

    class ReturnResult {
        boolean isB;
        int depth;

        public ReturnResult(int depth, boolean isB) {
            this.isB = isB;
            this.depth = depth;
        }
    }

    int helper2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper2(root.left);
        if (left == -1) {
            return -1;
        }
        int right = helper2(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return (left > right ? left : right) + 1;
    }
}
