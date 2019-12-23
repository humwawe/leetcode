package longest.univalue.path;

import common.TreeNode;

/**
 * @author hum
 */
public class LongestUnivaluePath {
    int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = helper(root.left);
        int r = helper(root.right);
        if (l == 0 && r == 0) {
            return 1;
        }
        int res = 1;
        if (root.left != null && root.right != null) {
            if (root.val == root.left.val && root.val == root.right.val) {
                result = Math.max(result, l + r);
                res = Math.max(l, r) + 1;
            } else if (root.val == root.left.val) {
                result = Math.max(result, l);
                res = Math.max(res, l + 1);
            } else if (root.val == root.right.val) {
                result = Math.max(result, r);
                res = Math.max(res, r + 1);
            }
        } else if (root.left == null) {
            if (root.val == root.right.val) {
                result = Math.max(result, r);
                res = Math.max(res, r + 1);
            }
        } else {
            if (root.val == root.left.val) {
                result = Math.max(result, l);
                res = Math.max(res, l + 1);
            }
        }
        return res;
    }
}
