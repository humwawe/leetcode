package maximum.difference.between.node.and.ancestor;

import common.TreeNode;

/**
 * @author hum
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return result;
    }

    private void helper(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }

        result = Math.max(result, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
        helper(root.left, Math.min(min, root.val), Math.max(max, root.val));
        helper(root.right, Math.min(min, root.val), Math.max(max, root.val));
    }
}
