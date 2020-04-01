package RangeSumOfBst;

import common.TreeNode;

/**
 * @author hum
 */
public class RangeSumOfBst {
    public int rangeSumBST(TreeNode root, int l, int r) {
        if (root == null) {
            return 0;
        }
        if (root.val > r) {
            return rangeSumBST(root.left, l, r);
        } else if (root.val < l) {
            return rangeSumBST(root.right, l, r);
        } else {
            return root.val + rangeSumBST(root.left, l, r) + rangeSumBST(root.right, l, r);
        }
    }
}
