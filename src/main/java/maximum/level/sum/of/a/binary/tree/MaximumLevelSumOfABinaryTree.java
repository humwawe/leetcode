package maximum.level.sum.of.a.binary.tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int res = root.val;
        int result = 1;
        int index = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int tmp = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                tmp += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (res < tmp) {
                res = tmp;
                result = index;
            }
            index++;
        }
        return result;
    }
}
