package validate.binary.search.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        boolean leftBoolean = true, rightBoolean = true;
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            leftBoolean = isValidBST(root.left) && root.val > getLeftMax(root.left);
        }
        if (root.right != null) {
            rightBoolean = isValidBST(root.right) && root.val < getRightMin(root.right);
        }
        return leftBoolean && rightBoolean;

    }

    private int getRightMin(TreeNode right) {
        while (right.left != null) {
            right = right.left;
        }
        return right.val;
    }

    private int getLeftMax(TreeNode left) {
        while (left.right != null) {
            left = left.right;
        }
        return left.val;
    }
}
