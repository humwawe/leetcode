package path.sum.III;

import common.TreeNode;

/**
 * @author hum
 */
public class PathSumIII {
    int result = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        helper(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return result;
    }

    private void helper(TreeNode root, int sum, int s) {
        if (root == null) {
            return;
        }
        if (sum == s + root.val) {
            result++;
        }
        helper(root.left, sum, s + root.val);
        helper(root.right, sum, s + root.val);
    }
}
