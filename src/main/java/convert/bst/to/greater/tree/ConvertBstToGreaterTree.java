package convert.bst.to.greater.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class ConvertBstToGreaterTree {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        root.val = root.val + sum;
        sum = root.val;
        helper(root.left);
    }
}
