package binary.search.tree.to.greater.sum.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class BinarySearchTreeToGreaterSumTree {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
    }
}
