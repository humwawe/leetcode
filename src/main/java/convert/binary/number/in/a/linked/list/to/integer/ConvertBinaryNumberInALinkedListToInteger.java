package convert.binary.number.in.a.linked.list.to.integer;

import common.ListNode;

/**
 * @author hum
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return Integer.valueOf(stringBuilder.toString(), 2);
    }
}
