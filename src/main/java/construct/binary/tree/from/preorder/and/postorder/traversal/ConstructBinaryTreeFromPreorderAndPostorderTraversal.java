package construct.binary.tree.from.preorder.and.postorder.traversal;

import common.TreeNode;

/**
 * @author hum
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = pre.length;
        if (len == 0) {
            return null;
        }
        return helper(pre, post, 0, len - 1, 0, len - 1);
    }

    private TreeNode helper(int[] pre, int[] post, int preL, int preR, int postL, int postR) {
        if (preL > preR || postL > postR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        if (preL == preR) {
            return root;
        }
        int i;
        for (i = postL; i <= postR; i++) {
            if (post[i] == pre[preL + 1]) {
                break;
            }
        }
        int leftLen = i - postL;
        root.left = helper(pre, post, preL + 1, preL + 1 + leftLen, postL, i);
        root.right = helper(pre, post, preL + +2 + leftLen, preR, i + 1, postR - 1);
        return root;
    }
}
