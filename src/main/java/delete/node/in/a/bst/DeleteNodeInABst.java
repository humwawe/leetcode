package delete.node.in.a.bst;

import common.TreeNode;

/**
 * @author hum
 */
public class DeleteNodeInABst {
    TreeNode p = null;

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode delNod = helper(root, key, null);
        if (delNod != null) {
            if (delNod.left != null && delNod.right != null) {
                TreeNode tmp;
                p = delNod;
                tmp = delNod.right;
                while (tmp.left != null) {
                    p = tmp;
                    tmp = tmp.left;
                }
                delNod.val = tmp.val;
                delNod = tmp;
            }
            TreeNode child = (delNod.left == null) ? delNod.right : delNod.left;
            if (p == null) {
                root = child;
            } else {
                if (p.left == delNod) {
                    p.left = child;
                } else {
                    p.right = child;
                }
            }
        }
        return root;
    }

    private TreeNode helper(TreeNode root, int key, TreeNode p) {
        if (root == null || root.val == key) {
            this.p = p;
            return root;
        } else if (root.val > key) {
            return helper(root.left, key, root);
        } else {
            return helper(root.right, key, root);
        }
    }
}
