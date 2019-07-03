package count.complete.tree.nodes;

import common.TreeNode;

/**
 * @author hum
 */
public class CountCompleteTreeNodes {
    private int result = 0;

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }
        result++;
        countNodes(root.left);
        countNodes(root.right);
        return result;

    }
}
