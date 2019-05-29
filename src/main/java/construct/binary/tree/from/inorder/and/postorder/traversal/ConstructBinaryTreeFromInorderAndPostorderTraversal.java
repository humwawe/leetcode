package construct.binary.tree.from.inorder.and.postorder.traversal;

import common.TreeNode;

/**
 * @author hum
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return helper(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int[] inorder, int index, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode head = new TreeNode(postorder[index]);
        int i;
        for (i = left; i <= right; i++) {
            if (inorder[i] == postorder[index]) {
                break;
            }
        }
        head.left = helper(postorder, inorder, index - (right - i) - 1, left, i - 1);
        head.right = helper(postorder, inorder, index - 1, i + 1, right);
        return head;
    }
}
