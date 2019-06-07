package binary.tree.preorder.traversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hum
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }
}
