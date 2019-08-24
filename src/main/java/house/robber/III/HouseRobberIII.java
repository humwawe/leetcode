package house.robber.III;

import common.TreeNode;

/**
 * @author hum
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        int result;
        if (!flag) {
            int temp = root.val;
            result = Math.max(temp + helper(root.left, true) + helper(root.right, true), helper(root.left, false) + helper(root.right, false));
        } else {
            int left = helper(root.left, false);
            int right = helper(root.right, false);
            result = left + right;
        }
        return result;
    }
}
