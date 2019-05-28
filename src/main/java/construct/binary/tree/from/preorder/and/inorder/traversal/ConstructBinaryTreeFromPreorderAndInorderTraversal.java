package construct.binary.tree.from.preorder.and.inorder.traversal;

import common.TreeNode;

/**
 * @author hum
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
//        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return helper2(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper2(int[] preorder, int[] inorder, int left, int right) {
        if (left > right || index >= preorder.length) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[index]);
        int i;
        for (i = left; i <= right; i++) {
            if (inorder[i] == preorder[index]) {
                break;
            }
        }
        index++;
        head.left = helper2(preorder, inorder, left, i - 1);
        head.right = helper2(preorder, inorder, i + 1, right);
        return head;

    }

    private TreeNode helper(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }

        TreeNode head = new TreeNode(preorder[preL]);
        int i;
        for (i = inL; i <= inR; i++) {
            if (inorder[i] == preorder[preL]) {
                break;
            }
        }
        int leftLen = i - inL;
        head.left = helper(preorder, inorder, preL + 1, preL + leftLen, inL, i - 1);
        head.right = helper(preorder, inorder, preL + leftLen + 1, preR, i + 1, inR);
        return head;
    }

}
