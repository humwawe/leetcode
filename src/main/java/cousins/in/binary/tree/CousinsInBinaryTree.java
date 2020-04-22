package cousins.in.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class CousinsInBinaryTree {
    int xp;
    int yp;

    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, 0, 0);
        if (xp / 1000 == yp / 1000 || xp % 1000 != yp % 1000) {
            return false;
        }
        return true;
    }

    private void helper(TreeNode root, int x, int y, int p, int l) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            xp = 1000 * p + l;
        }
        if (root.val == y) {
            yp = 1000 * p + l;
        }
        helper(root.left, x, y, root.val, l + 1);
        helper(root.right, x, y, root.val, l + 1);
    }
}

