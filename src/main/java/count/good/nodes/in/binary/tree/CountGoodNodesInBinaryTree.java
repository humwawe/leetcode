package count.good.nodes.in.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return helper(root, -0x3f3f3f3f);
    }

    private int helper(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int l = helper(root.left, Math.max(root.val, max));
        int r = helper(root.right, Math.max(root.val, max));
        if (root.val >= max) {
            return l + r + 1;
        }
        return l + r;
    }
}
