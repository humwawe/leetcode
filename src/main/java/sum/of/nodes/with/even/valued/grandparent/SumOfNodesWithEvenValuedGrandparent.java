package sum.of.nodes.with.even.valued.grandparent;

import common.TreeNode;

/**
 * @author hum
 */
public class SumOfNodesWithEvenValuedGrandparent {
    int result = 0;

    public int sumEvenGrandparent(TreeNode root) {
        helper(root, false, false);
        return result;
    }

    private void helper(TreeNode root, boolean p, boolean pp) {
        if (root == null) {
            return;
        }
        if (pp) {
            result += root.val;
        }
        helper(root.left, root.val % 2 == 0, p);
        helper(root.right, root.val % 2 == 0, p);
    }
}
