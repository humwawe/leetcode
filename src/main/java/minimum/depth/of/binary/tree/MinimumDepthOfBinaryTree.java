package minimum.depth.of.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class MinimumDepthOfBinaryTree {
    private int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return min;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (min > level) {
                min = level;
            }
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
