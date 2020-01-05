package split.linked.list.in.parts;

import common.ListNode;

/**
 * @author hum
 */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode tmp = root;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        int count = len / k;
        int remain = len % k;

        ListNode[] result = new ListNode[k];
        int index = 0;
        tmp = root;
        while (tmp != null) {
            result[index++] = tmp;
            ListNode prev = tmp;
            int start = 0;
            while (start < count) {
                prev = tmp;
                tmp = tmp.next;
                start++;
            }
            if (remain > 0) {
                prev = tmp;
                tmp = tmp.next;
                remain--;
            }
            prev.next = null;
        }
        return result;
    }
}
