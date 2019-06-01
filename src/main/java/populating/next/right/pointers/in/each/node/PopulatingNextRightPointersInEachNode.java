package populating.next.right.pointers.in.each.node;

import common.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node head = queue.poll();
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
                head.next = size == 0 ? null : queue.peek();

            }
        }
        return root;
    }
}
