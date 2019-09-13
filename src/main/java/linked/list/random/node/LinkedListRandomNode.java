package linked.list.random.node;

import common.ListNode;

import java.util.Random;

/**
 * @author hum
 */
public class LinkedListRandomNode {

    private ListNode node;

    public LinkedListRandomNode(ListNode head) {
        node = head;
    }

    public int getRandom() {
        int result = node.val;
        int i = 2;
        ListNode cur = node.next;
        while (cur != null) {
            int ran = new Random().nextInt(i);
            if (ran == 0) {
                result = cur.val;
            }
            cur = cur.next;
            i++;
        }
        return result;
    }
}
