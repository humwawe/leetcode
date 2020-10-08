package even.odd.tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hum
 */
public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        boolean f = true;
        if (root.val % 2 == 0) {
            return false;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<TreeNode> linkedList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    if (f) {
                        if (poll.left.val % 2 == 1) {
                            return false;
                        }
                    } else {
                        if (poll.left.val % 2 == 0) {
                            return false;
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        if (f) {
                            if (poll.left.val >= linkedList.getLast().val) {
                                return false;
                            }
                        } else {
                            if (poll.left.val <= linkedList.getLast().val) {
                                return false;
                            }
                        }
                    }
                    linkedList.add(poll.left);
                }
                if (poll.right != null) {
                    if (f) {
                        if (poll.right.val % 2 == 1) {
                            return false;
                        }
                    } else {
                        if (poll.right.val % 2 == 0) {
                            return false;
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        if (f) {
                            if (poll.right.val >= linkedList.getLast().val) {
                                return false;
                            }
                        } else {
                            if (poll.right.val <= linkedList.getLast().val) {
                                return false;
                            }
                        }
                    }
                    linkedList.add(poll.right);
                }
            }
            f = !f;
            queue.addAll(linkedList);
        }
        return true;
    }
}
