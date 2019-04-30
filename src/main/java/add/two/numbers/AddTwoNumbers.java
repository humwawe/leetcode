package add.two.numbers;

import common.ListNode;

/**
 * @author hum
 */


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tenPlace = 0;
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + tenPlace;
            int onePlace = sum % 10;
            tenPlace = sum / 10;
            ListNode newNode = new ListNode(onePlace);
            prev.next = newNode;
            prev = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + tenPlace;
            int onePlace = sum % 10;
            tenPlace = sum / 10;
            ListNode newNode = new ListNode(onePlace);
            prev.next = newNode;
            prev = newNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + tenPlace;
            int onePlace = sum % 10;
            tenPlace = sum / 10;
            ListNode newNode = new ListNode(onePlace);
            prev.next = newNode;
            prev = newNode;
            l2 = l2.next;
        }
        if (tenPlace != 0) {
            ListNode newNode = new ListNode(tenPlace);
            prev.next = newNode;
        }
        return head.next;
    }
}
