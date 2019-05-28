package binary.tree.zigzag.level.order.traversal;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hum
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        boolean zigzag = false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> result = new LinkedList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode head = queue.poll();
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
                if (zigzag) {
                    result.add(0, head.val);
                } else {
                    result.add(head.val);
                }

            }
            results.add(result);
            zigzag = !zigzag;
        }
        return results;
    }
}
