package copy.list.with.random.pointer;

import common.RandomNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class CopyListWithRandomPointer {
    Map<Integer, RandomNode> map = new HashMap<>();

    public RandomNode copyRandomList(RandomNode head) {
        helperNext(head);
        return helperRandom(head);
    }

    private RandomNode helperRandom(RandomNode head) {
        if (head == null) {
            return null;
        }
        RandomNode newHead = map.get(head.val);
        newHead.random = head.random != null ? map.get(head.random.val) : null;
        helperRandom(head.next);
        return newHead;
    }

    private RandomNode helperNext(RandomNode head) {
        if (head == null) {
            return null;
        }
        RandomNode newHead = new RandomNode(head.val, null, null);
        newHead.next = helperNext(head.next);
        map.put(newHead.val, newHead);
        return newHead;
    }
}
