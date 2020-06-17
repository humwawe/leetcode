package delete.leaves.with.a.given.value;

import common.TreeNode;

/**
 * @author hum
 */
public class DeleteLeavesWithAGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return helper(root, target);
    }

    private TreeNode helper(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = helper(root.left, target);
        root.right = helper(root.right, target);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                return null;
            }
        }
        return root;
    }
}
