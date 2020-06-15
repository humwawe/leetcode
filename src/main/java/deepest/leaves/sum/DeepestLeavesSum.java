package deepest.leaves.sum;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int result = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            result = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                result += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return result;
    }
}
