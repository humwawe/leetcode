package binary.tree.postorder.traversal;

import common.TreeNode;

import java.util.*;

/**
 * @author hum
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode last = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == last) {
                result.add(node.val);
                stack.pop();
                last = node;
                node = null;
            } else {
                node = node.right;
            }
        }
        return result;
    }

    private List<Integer> helper(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
        }
        Collections.reverse(list);
        return list;

    }

}
