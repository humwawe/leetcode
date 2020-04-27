package construct.binary.search.tree.from.preorder.traversal;

import common.TreeNode;

/**
 * @author hum
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        return helper(preorder, 0, len);
    }

    private TreeNode helper(int[] preorder, int i, int j) {
        if (i == j) {
            return null;
        }
        int k = i + 1;
        for (; k < j; k++) {
            if (preorder[k] > preorder[i]) {
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[i]);
        root.left = helper(preorder, i + 1, k);
        root.right = helper(preorder, k, j);
        return root;
    }
}
