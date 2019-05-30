package path.sum;

import common.TreeNode;

/**
 * @author hum
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        System.out.println(sum);
        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }
}
