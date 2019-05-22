package binary.tree.inorder.traversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hum
 */
public class BinaryTreeInorderTraversal {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        if (root == null) {
            return result;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("visit", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();

            if (command.command.equals("print")) {
                result.add(command.node.val);
            } else {
                if (command.node.right != null) {
                    stack.push(new Command("visit", command.node.right));
                }
                stack.push(new Command("print", command.node));
                if (command.node.left != null) {
                    stack.push(new Command("visit", command.node.left));
                }
            }
        }
        return result;
    }

    class Command {
        String command;
        TreeNode node;

        public Command(String command, TreeNode node) {
            this.command = command;
            this.node = node;
        }

    }
}
