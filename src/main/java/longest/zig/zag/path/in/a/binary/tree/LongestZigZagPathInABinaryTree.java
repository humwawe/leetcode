package longest.zig.zag.path.in.a.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class LongestZigZagPathInABinaryTree {
    int result = 0;

    public int longestZigZag(TreeNode root) {
        helper(root);
        return result;
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = helper(root.left);
        int[] r = helper(root.right);
        result = Math.max(result, l[1]);
        result = Math.max(result, r[0]);
        return new int[]{1 + l[1], 1 + r[0]};
    }
}
