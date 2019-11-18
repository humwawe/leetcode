package minimum.absolute.difference.in.bst;

import common.TreeNode;

public class MinimumAbsoluteDifferenceInBst {
    int result = Integer.MAX_VALUE;
    int prev = -1;

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev != -1) {
            result = Math.min(result, root.val - prev);
        }
        prev = root.val;
        helper(root.right);
    }
}
