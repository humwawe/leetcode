package linked.list.in.binary.tree;

import common.ListNode;
import common.TreeNode;

/**
 * @author hum
 */
public class LinkedListInBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val == head.val) {
            if (helper(head, root)) {
                return true;
            }
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean helper(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val != root.val) {
            return false;
        }

        return helper(head.next, root.left) || helper(head.next, root.right);
    }
}
