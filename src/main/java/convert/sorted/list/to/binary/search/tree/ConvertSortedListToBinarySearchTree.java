package convert.sorted.list.to.binary.search.tree;

import common.ListNode;
import common.TreeNode;

/**
 * @author hum
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return helper(head, len);
    }

    private TreeNode helper(ListNode head, int len) {
        if (len == 0) {
            return null;
        }

        ListNode mid = head;
        int tmp = len >> 1;
        int left = 0;
        while (tmp-- > 0) {
            mid = mid.next;
            left++;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(head, left);
        root.right = helper(mid.next, (len - 1) - left);
        return root;
    }
}
