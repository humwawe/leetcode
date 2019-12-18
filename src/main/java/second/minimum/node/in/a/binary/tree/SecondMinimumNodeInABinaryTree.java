package second.minimum.node.in.a.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        return helper(root, root.val);
    }

    private int helper(TreeNode root, int val) {
        if (root == null) {
            return -1;
        }
        if (root.val > val) {
            return root.val;
        }
        int l = helper(root.left, val);
        int r = helper(root.right, val);
        if (l > val && r > val) {
            return Math.min(l, r);
        }
        return Math.max(l, r);
    }
}
