package n.ary.tree.level.order.traversal;

import common.NAryNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author hum
 */
public class NAaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(NAryNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<NAryNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NAryNode poll = queue.poll();
                tmp.add(poll.val);
                queue.addAll(poll.children);
            }
            result.add(tmp);
        }
        return result;
    }
}
