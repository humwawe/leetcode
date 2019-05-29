package binary.tree.level.order.traversal.II;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hum
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> result = new LinkedList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode head = queue.poll();
                result.add(head.val);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            results.add(0, result);
        }
        return results;
    }
}
