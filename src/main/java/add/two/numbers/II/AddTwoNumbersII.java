package add.two.numbers.II;

import common.ListNode;

import java.math.BigInteger;

/**
 * @author hum
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        while (l1 != null) {
            stringBuilder1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stringBuilder2.append(l2.val);
            l2 = l2.next;
        }

        BigInteger b1 = new BigInteger(stringBuilder1.toString());
        BigInteger b2 = new BigInteger(stringBuilder2.toString());
        BigInteger b3 = b1.add(b2);
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (char c : b3.toString().toCharArray()) {
            head.next = new ListNode(c - '0');
            head = head.next;
        }
        return dummy.next;
    }
}
