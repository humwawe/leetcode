package flatten.binary.tree.to.linked.list;

import common.TreeNode;

/**
 * @author hum
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        flatten(tmp);
        TreeNode pre = root;
        while (pre.right != null) {
            pre = pre.right;
        }
        pre.right = tmp;
    }
}
