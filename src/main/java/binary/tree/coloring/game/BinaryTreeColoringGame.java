package binary.tree.coloring.game;

import common.TreeNode;

/**
 * @author hum
 */
public class BinaryTreeColoringGame {
    int l = 0;
    int r = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        helper(root, x);

        return n - (1 + l + r) > (1 + l + r) || l > n - l || r > n - r;
    }

    private int helper(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int l = helper(root.left, x);
        int r = helper(root.right, x);
        if (root.val == x) {
            this.l = l;
            this.r = r;
        }
        return 1 + l + r;
    }
}
